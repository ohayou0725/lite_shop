package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemAddrDto;
import com.ohayou.liteshop.entity.MemAddress;
import com.ohayou.liteshop.dao.MemAddressMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MemAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * 条件查询用户收货地址
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
            eq.eq(MemAddress::getUserId,memberId);
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
}
