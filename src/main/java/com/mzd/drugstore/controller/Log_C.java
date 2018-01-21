package com.mzd.drugstore.controller;

import com.mzd.drugstore.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册，登入，找回密码
 */
@Controller
public class Log_C {
    private final String uri = Constant.drugstore;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    @RequestMapping(uri + "register.do")
    public String registerC(HttpServletRequest request) {
        return "index";
    }
}
