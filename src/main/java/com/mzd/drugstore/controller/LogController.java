package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.LogServer;
import com.mzd.drugstore.utils.Md5Utils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("Log_C")
public class LogController {
    private final String string[] = {"0", "1", "2", "3", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final String api = Constant.drugstore;
    @Autowired
    private LogServer logServer;

    @RequestMapping(value = api + "/getcode", method = RequestMethod.GET)
    @ApiOperation("获取验证码")
    public MyResult getcode(HttpServletRequest request) {
        String sessionid = request.getSession().getId();
        String str = "";
        try {
            str += string[(int) (Math.random() * (string.length))];
            str += string[(int) (Math.random() * (string.length))];
            str += string[(int) (Math.random() * (string.length))];
            str += string[(int) (Math.random() * (string.length))];
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.getResult("500", "获取验证码失败", "", 0);
        }
        redisTemplate.opsForValue().set(sessionid, str);
        return ResultUtils.getResult("200", null, str, 0);
    }

    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    @RequestMapping(value = api + "/register", method = RequestMethod.GET)
    @ApiOperation("用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password2", value = "确认密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "verificationcode", value = "验证码", required = true, dataType = "String", paramType = "query")
    })
    public MyResult registerC(HttpServletRequest request, String verificationcode, String username, String password, String password2, String tel, String email) {
        try {
            String sessionid = request.getSession().getId();
            String s = (String) redisTemplate.opsForValue().get(sessionid);
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
            int i = logServer.registerS(user);
            if (i > 0) {
                return ResultUtils.getResult("200", null, null, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.getResult("500", "用户注册失败", null, 0);
    }
}
