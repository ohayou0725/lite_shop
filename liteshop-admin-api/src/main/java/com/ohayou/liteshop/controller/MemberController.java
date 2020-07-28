package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.MemUserQueryDto;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/24 下午10:35
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemUserService memUserService;

    /**
     * 会员列表查询
     * @param queryParam
     * @return Result
     */
    @GetMapping("/list")
    @ApiDesc("会员列表查询")
    public Result MemberList(@RequestParam("param") MemUserQueryDto memUserQueryDto,
                             @RequestParam("page") Map<String,Object> pageParam) {
        return memUserService.queryList(memUserQueryDto,pageParam);
    }
}
