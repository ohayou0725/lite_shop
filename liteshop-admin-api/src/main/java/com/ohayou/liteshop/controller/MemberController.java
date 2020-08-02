package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.*;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.*;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    MemAddressService memAddressService;

    @Autowired
    MemCollectService memCollectService;

    @Autowired
    MemHistoryService memHistoryService;

    @Autowired
    MemOpinionService memOpinionService;

    /**
     * 会员列表查询
     * @param queryParam
     * @return Result
     */
    @GetMapping("/list")
    @ApiDesc("会员列表查询")
    public Result MemberList(@Valid MemUserDto memUserDto, Map<String,Object> pageParam) throws InterruptedException {
        PageQuery<MemUser> pageQuery = new PageQuery<>();
        PageUtils pageUtils = memUserService.queryPage(memUserDto ,pageQuery.getPage(pageParam));
        return Result.success("page",pageUtils);
    }

    /**
     * 变更用户状态
     * @param memUserDto
     * @return
     */

    @PostMapping("/changeStatus")
    @ApiDesc("改变用户状态")
    public Result ChangeMemberStatus(@RequestBody @Valid MemUserDto memUserDto) {
        if (memUserDto == null || memUserDto.getId() == null || memUserDto.getId() == 0L) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = memUserService.changeStatus(memUserDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.CHANGE_STATUS_ERROR);
    }

    /**
     * 查询收货地址
     * @param addrDto
     * @param pageParam
     * @return
     */

    @GetMapping("/address/list")
    @ApiDesc("查询收货地址")
    public Result addressList(@Valid MemAddrDto addrDto, Map<String,Object> pageParam) {
        PageQuery<MemAddress> pageQuery = new PageQuery<>();
        PageUtils pageUtils = memAddressService.addrQueryPage(addrDto,pageQuery.getPage(pageParam));
        return Result.success("page",pageUtils);
    }


    /**
     * 查询用户收藏列表
     * @param collectDto
     * @param pageParam
     * @return
     */
    @GetMapping("/collect/list")
    @ApiDesc("查询会员收藏列表")
    public Result collectList(@Valid MemCollectDto collectDto, Map<String,Object> pageParam) {
        PageQuery<MemCollect> pageQuery = new PageQuery<>();
        PageUtils pageUtils = memCollectService.collectQueryPage(collectDto,pageQuery.getPage(pageParam));
        return Result.success("page",pageUtils);
    }

    /**
     * 查询用户浏览历史
     * @param historyDto
     * @param pageParam
     * @return
     */
    @GetMapping("/history/list")
    @ApiDesc("查询会员浏览历史")
    public Result historyList(@Valid MemHistoryDto historyDto, Map<String,Object> pageParam) {
        PageQuery<MemHistory> pageQuery = new PageQuery<>();
        PageUtils pageUtils = memHistoryService.historyQueryPage(historyDto,pageQuery.getPage(pageParam));
        return Result.success("page",pageUtils);
    }

    /**
     * 查询会员意见反馈
     * @param memHistoryDto
     * @param paramParam
     * @return
     */

    @GetMapping("/opinion/list")
    @ApiDesc("查询会员意见反馈")
    public Result opinionList(MemOpinionDto memOpinionDto, Map<String,Object> paramParam) {
        PageQuery<MemOpinion> pageQuery = new PageQuery<>();
        PageUtils pageUtils = memOpinionService.opinionQueryPage(memOpinionDto,pageQuery.getPage(paramParam));
        return Result.success("page",pageUtils);
    }
}
