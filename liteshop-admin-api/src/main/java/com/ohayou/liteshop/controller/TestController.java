package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.entity.User;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.UserService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author liyan
 * @date 2020/7/12 下午10:52
 */
@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result getUser() {
        HashMap<String, Object> params = new HashMap<>();
//        params.put("size","5");
//        params.put("page","2");
        PageQuery<User> pageQuery= new PageQuery<>();
        IPage<User> page = pageQuery.getPage(params, null, false);
        return Result.success("page",new PageUtils(page));
    }

    @GetMapping("/e")
    public Result error() {
        throw new GlobalException(ErrorCodeMsg.SERVER_ERROR);
    }
}
