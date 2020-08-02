package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AdminLogDto;
import com.ohayou.liteshop.entity.AdminLog;
import com.ohayou.liteshop.dao.AdminLogMapper;
import com.ohayou.liteshop.service.AdminLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.DateTimeUtil;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户操作日志表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class AdminLogServiceImpl extends ServiceImpl<AdminLogMapper, AdminLog> implements AdminLogService {

    /**
     * 条件查询page
     * @param page
     * @param userLogDto
     * @return
     */
    @Override
    public PageUtils queryPage(IPage<AdminLog> page, AdminLogDto userLogDto) {

        //构造查询条件
        LambdaQueryWrapper<AdminLog> adminLogQueryWrapper = new LambdaQueryWrapper<AdminLog>()
                .apply(null != userLogDto.getOperatingTime(), DateTimeUtil.sqlDateFormat("create_time") + " = {0}",userLogDto.getOperatingTime())
                .eq(StringUtils.isNotBlank(userLogDto.getStatus()),AdminLog::getStatus,userLogDto.getStatus())
                .eq(StringUtils.isNotBlank(userLogDto.getAdmin()),AdminLog::getAdmin,userLogDto.getAdmin());

//        page.setTotal(this.count(adminLogQueryWrapper));
        this.page(page,adminLogQueryWrapper);

        PageUtils pageUtils = new PageUtils(page);

        //entity转换为dto
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            List<AdminLog> collect = page.getRecords().stream()
                    .map(adminLog -> {
                        AdminLogDto adminLogDto = new AdminLogDto();
                        BeanUtils.copyProperties(adminLog, adminLogDto);
                        adminLogDto.setStatus(String.valueOf(adminLog.getStatus()));
                        return adminLog;
                    }).collect(Collectors.toList());

            pageUtils.setList(collect);
        }

        return pageUtils;
    }
}
