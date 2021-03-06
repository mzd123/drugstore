package com.mzd.drugstore.Listener;


import com.alibaba.fastjson.JSONObject;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void sessionCreated(HttpSessionEvent event) {

    }

    /**
     * 用户退出或者用户非安全退出等待session过期之后触发
     *
     * @param event
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        try {
            RedisTemplate redisTemplate = (RedisTemplate) WebApplicationContextUtils.getWebApplicationContext(event.getSession().getServletContext()).getBean("redisTemplate");
            HttpSession session = event.getSession();
            String sessionid = session.getId();
            //排除一个浏览器第一个人登入的时候的情况，这时候redis中还没有相应的值
            if (redisTemplate.opsForValue().get(Constant.userinfo + sessionid) != null) {
                String string = (String) redisTemplate.opsForValue().get(Constant.userinfo + sessionid);
                JSONObject object = JSONObject.parseObject(string);
                String userid = (String) object.get("userId");
                //清除redis中的所有关于这个用户的缓存信息
                redisTemplate.delete(redisTemplate.keys(Constant.userinfo + sessionid + "*"));
                //向数据库中插入记录，证明这个人已经退出了
                MyLog log = new MyLog();
                log.setCreatetime(TimeUtils.get_current_time());
                log.setLogId(MyStringUtils.getuuid());
                log.setUseId(userid);
                log.setTablename(Constant.cs_user);
                log.setTableId(userid);
                log.setOptionconent(Constant.logout);
                CommonDao commonDao = (CommonDao) WebApplicationContextUtils.getWebApplicationContext(event.getSession().getServletContext()).getBean("commonDao");
                int j = commonDao.insertLogD(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }
}
