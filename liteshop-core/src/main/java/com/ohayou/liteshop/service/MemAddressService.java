package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AddressFormDto;
import com.ohayou.liteshop.dto.MemAddrDto;
import com.ohayou.liteshop.entity.MemAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.MemberAddressVo;

import java.util.List;

/**
 * <p>
 * 收货地址表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemAddressService extends IService<MemAddress> {

    PageUtils addrQueryPage(MemAddrDto addrDto, IPage<MemAddress> page);

    List<MemberAddressVo> getMemberAddress(Long userId);

    boolean addAddress(AddressFormDto addressFormDto, Long id);

    AddressFormDto getAddressById(Long addressId, Long userId);

    boolean updateAddress(AddressFormDto addressFormDto, Long userId);

    boolean deleteAddress(Long addressId, Long userId);

    boolean setAddressByGoodsIdAndAddressId(Long goodsId, Long addressId,Long userId);

    MemberAddressVo getGoodsAddress(Long goodsId, Long id);
}
