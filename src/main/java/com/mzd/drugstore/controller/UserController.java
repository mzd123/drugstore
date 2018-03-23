package com.mzd.drugstore.controller;

import com.alibaba.fastjson.JSONObject;
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
import java.util.List;

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

    @RequestMapping(value = authority_api + "select_my_car", method = RequestMethod.GET)
    @ApiOperation("查询我的购物车")
    public MyResult select_my_car() {
        try {
            return userServer.select_my_carS();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "add_my_car", method = RequestMethod.GET)
    @ApiOperation("加入购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "productNumber", value = "商品数量（买多少个）", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "itemsMoney", value = "小计多少钱", dataType = "String", required = true, paramType = "query")
    })
    public MyResult add_my_car(String productId, String productNumber, String itemsMoney) {
        try {
            if (MyStringUtils.Object2String(productId).equals("")) {
                return ResultUtils.getResult("400", "商品id不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(productNumber).equals("")) {
                return ResultUtils.getResult("400", "商品数量不能位空", null, 0);
            }
            if (MyStringUtils.Object2String(itemsMoney).equals("")) {
                return ResultUtils.getResult("400", "商品小计总额不能位空", null, 0);
            }
            return userServer.add_my_carS(productId, productNumber, itemsMoney);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "delete_my_car", method = RequestMethod.GET)
    @ApiOperation("从购物车中删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemid", value = "商品项id", dataType = "String", required = true, paramType = "query")
    })
    public MyResult delete_my_car(String itemid) {
        try {
            if (MyStringUtils.Object2String(itemid).equals("")) {
                return ResultUtils.getResult("400", "商品项id不能为空", null, 0);
            }
            return userServer.delete_my_carS(itemid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "select_my_address", method = RequestMethod.GET)
    @ApiOperation("查询我的收货地址")
    public MyResult select_my_address() {
        try {
            return userServer.select_my_addressS();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "add_my_address", method = RequestMethod.GET)
    @ApiOperation("新增我的收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址", dataType = "String", required = true, paramType = "query")
    })
    public MyResult add_my_address(String address) {
        try {
            if (MyStringUtils.Object2String(address).equals("")) {
                return ResultUtils.getResult("400", "地址不能为空", null, 0);
            }
            return userServer.add_my_address(address);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "delete_my_address", method = RequestMethod.GET)
    @ApiOperation("删除我的收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressid", value = "收货地址id", dataType = "String", required = true, paramType = "query"),
    })
    public MyResult delete_my_address(String addressid) {
        try {
            if (MyStringUtils.Object2String(addressid).equals("")) {
                return ResultUtils.getResult("400", "地址id不能为空", null, 0);
            }
            return userServer.delete_my_addressD(addressid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


    @RequestMapping(value = authority_api + "get_an_order", method = RequestMethod.GET)
    @ApiOperation("下单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "items_ids_jsonstring", value = "商品项id集合转json字符串", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "addressid", value = "收货地址id", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "receiver", value = "收货地址人姓名", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "联系电话", dataType = "String", required = true, paramType = "query")
    })
    public MyResult get_an_order(String items_ids_jsonstring, String addressid, String receiver, String tel) {
        try {
            if (MyStringUtils.Object2String(items_ids_jsonstring).equals("")) {
                return ResultUtils.getResult("400", "商品项id集合转json的字符串不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(addressid).equals("")) {
                return ResultUtils.getResult("400", "收货地址不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(receiver).equals("")) {
                return ResultUtils.getResult("400", "收货人姓名不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(tel).equals("")) {
                return ResultUtils.getResult("400", "联系电话不能为空", null, 0);
            }
            List<String> list = JSONObject.parseArray(items_ids_jsonstring, String.class);
            //list.stream().forEach(System.out::println);
            return userServer.get_an_orderS(list, addressid, receiver, tel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }
}
