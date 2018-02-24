package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.UserServer;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api("UserController")
public class UserController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UserServer userServer;
    private final String api = Constant.drugstore;
    private final String authority_api = Constant.drugstore + Constant.authority;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = authority_api + "select_myinfo", method = RequestMethod.GET)
    @ApiOperation("查询我的基本信息")
    public MyResult select_myinfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect("/login.jsp");
                return null;
            } else {
                return ResultUtils.getResult("200", "获取自己基本信息成功", user, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


    @RequestMapping(value = authority_api + "update_myinfo", method = RequestMethod.GET)
    @ApiOperation("更新我的基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
    })
    public MyResult update_myinfo(HttpServletRequest request, String username, String password, String tel, String email) {
        try {
            if (MyStringUtils.Object2String(password).equals("")) {
                return ResultUtils.getResult("400", "密码不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(username).equals("")) {
                return ResultUtils.getResult("400", "用户名不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(tel).equals("")) {
                return ResultUtils.getResult("400", "手机号不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(email).equals("")) {
                return ResultUtils.getResult("400", "邮箱不能为空", null, 0);
            }
            User user = (User) request.getSession().getAttribute("user");
            user.setUserTel(tel);
            user.setUserEmail(email);
            user.setUserName(username);
            user.setUserPassword(password);
            return userServer.update_myinfoS(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


    @RequestMapping(value = authority_api + "add_comment", method = RequestMethod.POST)
    @ApiOperation("用户评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productid", value = "商品id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "commentContent", value = "评论内容", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "imgs", value = "评论图片集合", required = false, dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "commentLevel", value = "评论等级", required = false, dataType = "String", paramType = "query")
    })
    public MyResult add_comment(HttpServletRequest request, String productid, String commentContent, String commentLevel, MultipartFile[] imgs) {
        try {
            if (MyStringUtils.Object2String(productid).equals("")) {
                return ResultUtils.getResult("400", "密码不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(commentContent).equals("")) {
                return ResultUtils.getResult("400", "用户名不能为空", null, 0);
            }
            User user = (User) request.getSession().getAttribute("user");
            int i = userServer.add_commentS(user, productid, commentContent, imgs, commentLevel);
            if (i > 0) {
                return ResultUtils.getResult("200", "评论成功", null, 0);
            }
            return ResultUtils.getResult("500", "评论失败", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


}
