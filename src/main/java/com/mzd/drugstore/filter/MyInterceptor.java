package com.mzd.drugstore.filter;

import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final String api = Constant.drugstore + Constant.authority;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        /**
         * /drugstore/register.do
         * 无论有没有参数都是这个
         */
        String uri = request.getRequestURI();
        //如果是登入或者注册或者是找回密码等请求不进行拦截
        if (!uri.contains(api)) {
            return true;
        } else {
            String sessionid = MyStringUtils.Object2String(request.getSession().getId());
            if (!sessionid.equals("")) {
                //获取改用的所有权限点
                List authoritys = redisTemplate.opsForList().range(sessionid, 0, -1);
                if (authoritys.size() != 0) {
                    if (authoritys.contains(uri)) {
                        return true;
                    }
                    request.getSession().setAttribute("msg", "权限不足");
                }
            } else {
                //还没登入过
                request.getSession().setAttribute("msg", "你还没登入过，请先登入");
            }
        }
        response.sendRedirect("/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
