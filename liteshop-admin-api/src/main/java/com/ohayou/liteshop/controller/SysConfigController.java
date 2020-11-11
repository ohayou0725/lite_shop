package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.entity.SysFreightConfig;
import com.ohayou.liteshop.entity.SysOrderConfig;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.SysFreightConfigService;
import com.ohayou.liteshop.service.SysOrderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyan
 * @date 2020/11/5 下午9:44
 */
@RestController
@RequestMapping("/setting")
public class SysConfigController {

    @Autowired
    SysOrderConfigService sysOrderConfigService;

    @Autowired
    SysFreightConfigService sysFreightConfigService;

    @ApiDesc("获取订单配置")
    @GetMapping("/order")
    public Result getOrderConfig() {
        List<SysOrderConfig> list = sysOrderConfigService.list();
        return Result.success("data",list.get(0));
    }

    @ApiDesc("获取运费配置")
    @GetMapping("/freight")
    public Result getFreightConfig() {
        List<SysFreightConfig> list = sysFreightConfigService.list();
        return Result.success("data",list.get(0));
    }

    @ApiDesc("修改订单配置")
    @PostMapping("/order")
    public Result updateOrderConfig(@RequestBody SysOrderConfig sysOrderConfig) {
        Long id = sysOrderConfig.getId();
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = sysOrderConfigService.updateOrderConfig(sysOrderConfig);
        return result ? Result.success() : Result.error(ErrorCodeMsg.CONFIG_UPDATE_ERROR);
    }

    @ApiDesc("修改运费配置")
    @PostMapping("/freight")
    public Result updateFreightConfig(@RequestBody SysFreightConfig sysFreightConfig) {
        Long id = sysFreightConfig.getId();
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = sysFreightConfigService.updateFreightConfig(sysFreightConfig);
        return result ? Result.success() : Result.error(ErrorCodeMsg.CONFIG_UPDATE_ERROR);
    }
}
