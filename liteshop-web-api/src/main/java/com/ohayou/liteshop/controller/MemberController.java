package com.ohayou.liteshop.controller;

import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.UUID;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.CaptchaKey;
import com.ohayou.liteshop.dto.AddressFormDto;
import com.ohayou.liteshop.dto.MemberLoginFormDto;

import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.service.MemAddressService;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.LoginCaptchaUtil;
import com.ohayou.liteshop.vo.MemberAddressVo;
import com.ohayou.liteshop.vo.MemberInfoVo;
import com.ohayou.liteshop.dto.RegisterFormDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/1/4 下午9:04
 */
@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    MemUserService memUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemAddressService memAddressService;

    @GetMapping("/getCaptcha")
    @ApiDesc("获取登录图形验证码")
    public Result getLoginCaptcha() {

        //生产验证码,将uuid作为健，code作为值存入到redis，设置过期时间为1分钟
        LineCaptcha captcha = (LineCaptcha) LoginCaptchaUtil.createCaptcha();
        String code = captcha.getCode();
        String key = UUID.randomUUID().toString().replace("-","");
        CaptchaKey captchaKey = new CaptchaKey(key,60);
        redisService.set(captchaKey.getPrefix(),code,captchaKey.expireSeconds());
        //将base64编码返回前端
        Map<String,String> captchaMap = new HashMap<>();
        captchaMap.put("captchaId",key);
        captchaMap.put("img",captcha.getImageBase64());
        return Result.success("captcha",captchaMap);
    }

    @ApiDesc("用户登录")
    @PostMapping("/login")
    public Result login(@Valid @RequestBody MemberLoginFormDto memberLoginFormDto) {

        String token = memUserService.login(memberLoginFormDto);
        return Result.success("token",token);
    }

    @ApiDesc("获取用户信息")
    @GetMapping("/info")
    public Result getUserInfo(Authentication authentication) {
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        MemberInfoVo memberInfoVo = new MemberInfoVo();
        BeanUtils.copyProperties(memberUserDetails,memberInfoVo);
        return Result.success("info",memberInfoVo);
    }

    @ApiDesc("新用户注册")
    @PostMapping("/registry")
    public Result MemberRegistry(@Valid @RequestBody RegisterFormDto registerFormDto) {
        boolean result = memUserService.registry(registerFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.REGISTER_ERROR);
    }

    @ApiDesc("获取用户收货地址")
    @GetMapping("/address/list")
    public Result getAddressList(Authentication authentication) {
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        List<MemberAddressVo> list = memAddressService.getMemberAddress(memberUserDetails.getId());
        return Result.success("list",list);
    }

    @ApiDesc("添加用户收货地址")
    @PostMapping("/address")
    public Result addAddress(@Valid @RequestBody AddressFormDto addressFormDto,Authentication authentication) {
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memAddressService.addAddress(addressFormDto,memberUserDetails.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.ADD_ADDRESS_ERROR);
    }

    @ApiDesc("查询用户收地址详情")
    @GetMapping("/address/{id}")
    public Result getAddress(@PathVariable("id") Long id ,Authentication authentication) {
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        AddressFormDto addressFormDto = memAddressService.getAddressById(id,memberUserDetails.getId());
        return Result.success("detail",addressFormDto);
    }

    @ApiDesc("更新收货地址")
    @PutMapping("/address")
    public Result updateAddress(@Valid @RequestBody AddressFormDto addressFormDto, Authentication authentication) {
        if (null == addressFormDto.getAddressId() || addressFormDto.getAddressId() < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memAddressService.updateAddress(addressFormDto,memberUserDetails.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_ADDRESS_ERROR);
    }

    @ApiDesc("删除收货地址")
    @DeleteMapping("/address/{id}")
    public Result deleteAddress(@PathVariable("id") Long id, Authentication authentication) {
        if (null == id|| id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memAddressService.deleteAddress(id,memberUserDetails.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.DELETE_ADDRESS_ERROR);
    }

    @ApiDesc("修改商品下当前收货地址")
    @PutMapping("/setAddress")
    public Result setGoodsAddress(@RequestBody Map<String,String> params,Authentication authentication) {
        Long goodsId = null;
        Long addressId = null;
        try {
           goodsId = Long.parseLong(params.get("goodsId"));
           addressId = Long.parseLong(params.get("addressId"));
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        if (goodsId < 1 || addressId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        memAddressService.setAddressByGoodsIdAndAddressId(goodsId,addressId,memberUserDetails.getId());
        return Result.success();
    }

    @ApiDesc("获取用户在商品下收货地址")
    @GetMapping("/getAddress")
    public Result getGoodsAddress(@RequestParam("goodsId") Long goodsId, Authentication authentication) {
        if (null == goodsId || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        MemberAddressVo memberAddressVo = memAddressService.getGoodsAddress(goodsId, memberUserDetails.getId());
        return Result.success("address",memberAddressVo);
    }

}
