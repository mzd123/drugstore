package com.mzd.drugstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.CommonServer;
import com.mzd.drugstore.server.LoginServer;
import com.mzd.drugstore.utils.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@Api("LoginController")
public class LoginController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final String api = Constant.drugstore;
    @Autowired
    private LoginServer loginServer;
    @Autowired
    private CommonServer commonServer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 注册前判断用户名是否已经注册过了
     *
     * @param username
     * @return
     */
    @RequestMapping(value = api + "ifusernameisoccupied", method = RequestMethod.GET)
    @ApiOperation("判断用户名是否被占用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query")
    })
    public MyResult ifusernameisoccupied(String username) {
        try {
            if (!MyStringUtils.Object2String(username).equals("")) {
                User user = new User();
                user.setUserName(username);
                boolean isF = loginServer.if_user_exist_S(user);
                if (!isF) {
                    return ResultUtils.getResult("200", "用户名未被占用", "", 0);
                }
                return ResultUtils.getResult("400", "用户名已经被占用", "", 0);
            }
            return ResultUtils.getResult("400", "用户名不能为空", "", 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


    @RequestMapping(value = api + "getcode", method = RequestMethod.GET)
    @ApiOperation("获取验证码")
    public MyResult getcode(HttpServletRequest request) {
        try {
            String sessionid = request.getSession().getId();
            String str = "";
            str = MyStringUtils.getcode(4);
            redisTemplate.opsForValue().set(sessionid + Constant.user_verificationcode, str, Constant.verificationcode_time, TimeUnit.SECONDS);
            HashMap hashMap = new HashMap();
            hashMap.put("verificationcode", str);
            return ResultUtils.getResult("200", "获取验证码成功", hashMap, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }


    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    @RequestMapping(value = api + "register", method = RequestMethod.GET)
    @ApiOperation("用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password2", value = "确认密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "verificationcode", value = "验证码", required = true, dataType = "String", paramType = "query")
    })
    public MyResult register(HttpServletRequest request, String verificationcode, String username, String password, String password2, String tel, String email) {
        try {
            String sessionid = request.getSession().getId();
            String s = (String) redisTemplate.opsForValue().get(sessionid + Constant.user_verificationcode);
            if (s == null || s.equals("")) {
                return ResultUtils.getResult("400", "验证码已过期", null, 0);
            }
            if (!MyStringUtils.Object2String(verificationcode).equals(s)) {
                //验证码不正确
                return ResultUtils.getResult("400", "验证码不正确", null, 0);
            }
            if (MyStringUtils.Object2String(password).equals("")) {
                return ResultUtils.getResult("400", "密码不能为空", null, 0);
            }
            if ((!MyStringUtils.Object2String(password).equals(MyStringUtils.Object2String(password2)))) {
                return ResultUtils.getResult("400", "两次密码不一致", null, 0);
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
            User user = new User();
            user.setUserCreatetime(TimeUtils.get_current_time());
            user.setUserEmail(email);
            user.setUserId(MyStringUtils.getuuid());
            user.setUserName(username);
            user.setUserPassword(Md5Utils.getMD5(password));
            user.setUserStatus(Constant.liefstatus);
            user.setUserTel(tel);
            user.setUserRoleid(Constant.generaluserR_id);
            int i = loginServer.registerS(user);
            if (i > 0) {
                return ResultUtils.getResult("200", null, null, 0);
            }
            return ResultUtils.getResult("500", "用户注册失败", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    /**
     * 找回密码第一步 发送邮件
     *
     * @param username
     * @param email
     * @param request
     * @return
     */
    @RequestMapping(value = api + "findMypassword_sendEmail", method = RequestMethod.GET)
    @ApiOperation("根据邮箱找回密码---发送邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
    })
    public MyResult findMypassword_sendEmail(String username, String email, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(username).equals("")) {
                return ResultUtils.getResult("400", "用户名不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(email).equals("")) {
                return ResultUtils.getResult("400", "邮箱不能为空", null, 0);
            }
            //先判断用户名和邮箱是否一致
            User user = new User();
            user.setUserName(username);
            user.setUserEmail(email);
            boolean isF = loginServer.if_user_exist_S(user);
            if (isF) {
                /**
                 * 获取验证码
                 */
                String str = MyStringUtils.getcode(4);
                EmailUtils.sendEmail(email, str, username);
                /**
                 * 发送邮件成功 - - 向redis中存一个验证码，修改密码的时候带上这个验证码
                 * 一、判断这个用户名是否要被修改密码
                 * 二、防止这个用户刚发送玩邮件，别人直接调用修改密码的接口。
                 */
                String sessionid = request.getSession().getId();
                redisTemplate.opsForValue().set(sessionid + Constant.user_verificationcode, str, Constant.verificationcode_time, TimeUnit.SECONDS);
                return ResultUtils.getResult("200", "发送邮件成功", null, 0);
            } else {
                return ResultUtils.getResult("400", "账号和邮件不相匹配，发送邮件失败", null, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    /**
     * 找回密码第二步 修改密码
     *
     * @param username
     * @param newpassword
     * @param verificationcode
     * @param request
     * @return
     */
    @RequestMapping(value = api + "findMypassword_updatepasswprd", method = RequestMethod.GET)
    @ApiOperation("根据邮箱找回密码---设置新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "verificationcode", value = "验证码", required = true, dataType = "String", paramType = "query"),
    })
    public MyResult findMypassword_updatepasswprd(String username, String newpassword, String verificationcode, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(username).equals("")) {
                return ResultUtils.getResult("400", "用户名不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(newpassword).equals("")) {
                return ResultUtils.getResult("400", "新密码不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(verificationcode).equals("")) {
                return ResultUtils.getResult("400", "验证码不能为空", null, 0);
            }
            String sessionid = request.getSession().getId();
            String code = (String) redisTemplate.opsForValue().get(sessionid + Constant.user_verificationcode);
            if (code == null || code.equals("")) {
                return ResultUtils.getResult("400", "验证码已过期", null, 0);
            }
            if (!verificationcode.equals(code)) {
                return ResultUtils.getResult("400", "验证码错误", null, 0);
            }
            User user = new User();
            user.setUserName(username);
            /**
             * 获取这个用户所有信息
             */
            List<User> list = loginServer.getuserS(user);
            user = list.get(0);
            user.setUserPassword(Md5Utils.getMD5(newpassword));
            boolean isF = loginServer.updateuserByuserNameS(user);
            if (isF) {
                return ResultUtils.getResult("200", "修改密码成功", null, 0);
            }
            return ResultUtils.getResult("500", "修改密码失败，请重试！", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    /**
     * @param username
     * @param password
     * @param verificationcode
     * @param request
     * @return
     */
    @RequestMapping(value = api + "login", method = RequestMethod.GET)
    @ApiOperation("用户登入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "verificationcode", value = "验证码", required = true, dataType = "String", paramType = "query"),
    })
    public MyResult login(String username, String password, String verificationcode, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(username).equals("")) {
                return ResultUtils.getResult("400", "用户名不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(password).equals("")) {
                return ResultUtils.getResult("400", "新密码不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(verificationcode).equals("")) {
                return ResultUtils.getResult("400", "验证码不能为空", null, 0);
            }
            String sessionid = request.getSession().getId();
            String code = (String) redisTemplate.opsForValue().get(sessionid + Constant.user_verificationcode);
            if (code == null || code.equals("")) {
                return ResultUtils.getResult("400", "验证码已过期", null, 0);
            }
            if (!verificationcode.equals(code)) {
                return ResultUtils.getResult("400", "验证码错误", null, 0);
            }
            User user = new User();
            user.setUserPassword(Md5Utils.getMD5(password));
            user.setUserName(username);
            List<User> list = loginServer.getuserS(user);
            if (list != null && list.size() > 0) {
                /**
                 *用户存在
                 */
                user = list.get(0);
                /**
                 * 处理同一个浏览器不同用户登入时，session里面的值保留问题，即同一个浏览器不同用户登入，第二个登入的时候，第一个登入的session将会被销毁
                 */
                request.getSession().invalidate();
                /**
                 * 处理用户非安全退出之后，又重新登入的情况
                 * 先销毁原来的session，然后记录数据库这个人已经退出，然后再登入
                 * 缺点在于：一个账号只能一个用户登入，第二个会将第一个用户挤下来
                 */
                //从ServletContext中获取这个人上次登入时候的session
                Map map = (Map) request.getSession().getServletContext().getAttribute("map");
                HttpSession session = (HttpSession) map.get(user.getUserId());
                if (session != null) {
                    session.invalidate();
                }
                /**
                 * 处理该用户本次登入
                 */
                //操作日志，证明这个人登入
                MyLog mylog = new MyLog();
                mylog.setTableId(user.getUserId());
                mylog.setOptionconent(Constant.login);
                mylog.setUseId(user.getUserId());
                mylog.setLogId(MyStringUtils.getuuid());
                mylog.setTablename(Constant.cs_user);
                mylog.setCreatetime(TimeUtils.get_current_time());
                commonServer.insertLogS(mylog);
                redisTemplate.opsForValue().set(Constant.userinfo + sessionid, JSONObject.toJSONString(user));
                request.getSession().setAttribute("user", user);
                return ResultUtils.getResult("200", "登入成功", user, 0);
            }
            return ResultUtils.getResult("400", "账号或密码错误", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = api + "logout", method = RequestMethod.GET)
    @ApiOperation("用户安全退出")
    public MyResult logout(HttpServletRequest request) {
        try {
            String sessionid = request.getSession().getId();
            if (!MyStringUtils.Object2String(sessionid).equals("")) {
                //销毁该用户的session
                request.getSession().invalidate();
                return ResultUtils.getResult("200", "安全退出！！！", null, 0);
            }
            return ResultUtils.getResult("400", "未登入者进行退出操作！！！", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }
}
