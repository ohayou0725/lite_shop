package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.MemberGoodsAddressKey;
import com.ohayou.liteshop.dto.AddressFormDto;
import com.ohayou.liteshop.dto.MemAddrDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MemAddress;
import com.ohayou.liteshop.dao.MemAddressMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MemAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.MemberAddressVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 收货地址表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemAddressServiceImpl extends ServiceImpl<MemAddressMapper, MemAddress> implements MemAddressService {
    @Autowired
    MemUserService memUserService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    RedisService redisService;

    /**
     * 条件查询用户收货地址
     *
     * @param addrDto
     * @param page
     * @return
     */
    @Override
    public PageUtils addrQueryPage(MemAddrDto addrDto, IPage<MemAddress> page) {
        LambdaQueryWrapper<MemAddress> eq = new LambdaQueryWrapper<MemAddress>()
                .eq(StringUtils.isNotBlank(addrDto.getReceiver()), MemAddress::getReceiver, addrDto.getReceiver())
                .eq(StringUtils.isNotBlank(addrDto.getReceiverMobile()), MemAddress::getReceiverMobile, addrDto.getReceiverMobile());
        if (StringUtils.isNoneBlank(addrDto.getMobile())) {
            Long memberId = memUserService.getMemIdByMobile(addrDto.getMobile());
            eq.eq(MemAddress::getUserId, memberId);
        }
        this.page(page, eq);
        PageUtils pageUtils = new PageUtils(page);
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            List<MemAddrDto> collect = page.getRecords().stream()
                    .map(memAddress -> {
                        MemAddrDto memAddrDto = new MemAddrDto();
                        BeanUtils.copyProperties(memAddress, memAddrDto);
                        MemUser user = memUserService.getById(memAddress.getUserId());
                        memAddrDto.setMemNickname(user.getNickname());
                        memAddrDto.setMobile(user.getMobile());
                        return memAddrDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }

        return pageUtils;
    }

    /**
     * 获取当前用户收货地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    @Override
    public List<MemberAddressVo> getMemberAddress(Long userId) {
        LambdaQueryWrapper<MemAddress> memAddressLambdaQueryWrapper = new LambdaQueryWrapper<>();
        memAddressLambdaQueryWrapper.eq(MemAddress::getUserId, userId);
        List<MemAddress> list = this.list(memAddressLambdaQueryWrapper);
        return list.stream().map(memAddress -> {
            MemberAddressVo memberAddressVo = new MemberAddressVo();
            BeanUtils.copyProperties(memAddress, memberAddressVo);
            memberAddressVo.setDefault(memAddress.getIsDefault().equals(1));
            return memberAddressVo;
        }).collect(Collectors.toList());
    }

    /**
     * 用户添加收货地址
     *
     * @param addressFormDto 地址表单
     * @param id             用户id
     * @return 是否添加成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addAddress(AddressFormDto addressFormDto, Long userId) {
        MemAddress memAddress = new MemAddress();
        memAddress.setAddress(addressFormDto.getAddress());
        memAddress.setArea(addressFormDto.getArea());
        memAddress.setReceiver(addressFormDto.getReceiver());
        memAddress.setReceiverMobile(addressFormDto.getReceiverMobile());
        memAddress.setUserId(userId);
        memAddress.setPostalCode(addressFormDto.getPostalCode());
        memAddress.setAreaCode(addressFormDto.getAreaCode());

        List<MemAddress> list = this.list(new LambdaQueryWrapper<MemAddress>().eq(MemAddress::getUserId, userId));
        if (!addressFormDto.isDefaultAddress() && list.size() < 1) {
            memAddress.setIsDefault(1);
        }
        if (!addressFormDto.isDefaultAddress() && list.size() > 0) {
            memAddress.setIsDefault(0);
        }
        if (addressFormDto.isDefaultAddress()) {
            memAddress.setIsDefault(1);
        }
        boolean save = this.save(memAddress);
        if (addressFormDto.isDefaultAddress() && save && list.size() > 0) {
            List<MemAddress> collect = list.stream().filter(address ->
            {
                return address.getIsDefault().equals(1);
            }).limit(1).collect(Collectors.toList());
            MemAddress memAddress1 = collect.get(0);
            memAddress1.setIsDefault(0);
            if (!this.updateById(memAddress1)) {
                throw new GlobalException(ErrorCodeMsg.ADD_ADDRESS_ERROR);
            }
        }
        return save;
    }

    /**
     * 根据addressId查询地址详情
     * @param addressId 地址id
     * @param userId 用户id
     * @return 地址详情
     */
    @Override
    public AddressFormDto getAddressById(Long addressId, Long userId) {
        MemAddress memAddress = this.getById(addressId);
        if (null == memAddress) {
            throw new GlobalException(ErrorCodeMsg.ADDRESS_NOT_FOUND);
        }
        //防止横向越权
        if (!memAddress.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        AddressFormDto addressFormDto = new AddressFormDto();
        addressFormDto.setAddressId(memAddress.getId());
        addressFormDto.setDefaultAddress(memAddress.getIsDefault().equals(1));
        BeanUtils.copyProperties(memAddress,addressFormDto);
        return addressFormDto;
    }

    /**
     * 更新地址
     * @param addressFormDto 地址表单
     * @param userId 用户ID
     * @return 是否修改成功
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateAddress(AddressFormDto addressFormDto, Long userId) {
        //校验是否横向越权
        MemAddress address = this.getById(addressFormDto.getAddressId());
        if (null == address) {
            throw new GlobalException(ErrorCodeMsg.ADDRESS_NOT_FOUND);
        }
        if (!address.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        BeanUtils.copyProperties(addressFormDto,address);
        address.setIsDefault(addressFormDto.isDefaultAddress() ? 1 : 0);

        MemAddress one = this.getOne(new LambdaQueryWrapper<MemAddress>().eq(MemAddress::getUserId, userId).eq(MemAddress::getIsDefault, 1));
        boolean update = this.updateById(address);
        if (!update) {
            throw new GlobalException(ErrorCodeMsg.UPDATE_ADDRESS_ERROR);
        }
        if (addressFormDto.isDefaultAddress() && null != one) {
            one.setIsDefault(0);
            if (!this.updateById(one)) {
                throw new GlobalException(ErrorCodeMsg.UPDATE_ADDRESS_ERROR);
            }
        }
        return update;
    }

    /**
     * 根据id删除收货地址
     * @param id
     * @param id1
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteAddress(Long addressId, Long userId) {
        //校验是否横向越权
        MemAddress address = this.getById(addressId);
        if (null == address) {
            throw new GlobalException(ErrorCodeMsg.ADDRESS_NOT_FOUND);
        }
        if (!address.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean delete = this.removeById(addressId);
        if (!delete) {
            throw new GlobalException(ErrorCodeMsg.DELETE_ADDRESS_ERROR);
        }
        List<MemAddress> list = this.list(new LambdaQueryWrapper<MemAddress>().eq(MemAddress::getUserId, userId));
        if (address.getIsDefault().equals(1) && list.size() > 0 ) {
            MemAddress memAddress = list.get(0);
            memAddress.setIsDefault(1);
            if (!this.updateById(memAddress)) {
                throw new GlobalException(ErrorCodeMsg.DELETE_ADDRESS_ERROR);
            }
        }
        return delete;
    }

    /**
     * 设置商品下用户所选收货地址
     * @param goodsId
     * @param addressId
     * @return
     */
    @Override
    public boolean setAddressByGoodsIdAndAddressId(Long goodsId, Long addressId,Long userId) {
        //判断商品和地址是否存在
        int goodsCount = goodsSpuService.count(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getId, goodsId));
        int addressCount = this.count(new LambdaQueryWrapper<MemAddress>().eq(MemAddress::getId,addressId));
        if (goodsCount < 1 || addressCount < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberGoodsAddressKey memberGoodsAddressKey = new MemberGoodsAddressKey(String.valueOf(userId));
        return redisService.hset(memberGoodsAddressKey.getPrefix(),String.valueOf(goodsId),addressId);
    }

    @Override
    public MemberAddressVo getGoodsAddress(Long goodsId, Long userId) {
        MemberGoodsAddressKey memberGoodsAddressKey = new MemberGoodsAddressKey(String.valueOf(userId));
        Map<Object, Object> map =  redisService.hmget(memberGoodsAddressKey.getPrefix());
        MemAddress memAddress = null;
        if (null != map && map.containsKey(String.valueOf(goodsId))) {
            Long value = Long.parseLong(String.valueOf(map.get(String.valueOf(goodsId))));memAddress = this.getById(value);
        } else {
            //如果没有指定商品地址则返回默认地址
            memAddress  = this.getOne(new LambdaQueryWrapper<MemAddress>().eq(MemAddress::getIsDefault, 1).eq(MemAddress::getUserId,userId));
        }

        MemberAddressVo memberAddressVo = new MemberAddressVo();
        if (null != memAddress) {
            BeanUtils.copyProperties(memAddress,memberAddressVo);
            memberAddressVo.setDefault(memAddress.getIsDefault().equals(1));
        }
        return memberAddressVo;
    }
}
