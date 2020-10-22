package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.AdminLogDto;
import com.ohayou.liteshop.entity.AdminLog;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.AdminLogService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/25 下午7:54
 */

/**
 * 用户操作日志
 */
@RestController
@RequestMapping("system/user/log")
public class AdminLogController {

    @Autowired
    AdminLogService adminLogService;

    /**
     * 套件查询所有操作日志
     * @return
     */
    @ApiDesc("查询用户操作日志")
    @GetMapping("/list")
    public Result getAllLog(@RequestParam Map<String,Object> pageParam, AdminLogDto userLogDto) {
        PageQuery<AdminLog> adminLogPageQuery = new PageQuery<>();
        IPage<AdminLog> page = adminLogPageQuery.getPage(pageParam, "create_time", false);
        PageUtils pageUtils = adminLogService.queryPage(page, userLogDto);
        return Result.success("page",pageUtils);
    }
}
