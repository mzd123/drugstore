package com.mzd.drugstore.server;

import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.LoginDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoginServer {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private CommonDao commonDao;

    /**
     * 判断这个用户是否存在
     *
     * @param user
     * @return
     */
    public boolean if_user_exist_S(User user) {
        List list = loginDao.SelectuserListD(user);
        if (list != null) {
            if (list.size() > 0) {
                return true;
            }
        }
        //不存在
        return false;
    }


    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int registerS(User user, HttpServletRequest request) throws Exception {
        int ii = 0;
        int i = loginDao.registerD(user);
        if (i > 0) {
            //对日志表的操作
            MyLog log = new MyLog();
            log.setCreatetime(TimeUtils.get_current_time());
            log.setLogId(MyStringUtils.getuuid());
            log.setUseId(user.getUserId());
            log.setTablename(Constant.cs_user);
            log.setTableId(user.getUserId());
            log.setOptionconent(Constant.insert);
            log.setOptionip(IpUtils.getIp(request));
            int j = commonDao.insertLogD(log);
            if (j > 0) {
                ii = 1;
            }
        }
        return ii;
    }

    /**
     * 根据用户信息查询满足条件的所有信息用户
     *
     * @param user
     * @return
     */
    public List<User> getuserS(User user) {
        return loginDao.SelectuserListD(user);
    }


    /**
     * 根据用户信息更改用户
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public boolean updateuserByuserNameS(User user, HttpServletRequest request) throws Exception {
        int ii = 0;
        int i = loginDao.updateuserByuserNameD(user);
        if (i > 0) {
            //对日志表的操作
            MyLog log = new MyLog();
            log.setCreatetime(TimeUtils.get_current_time());
            log.setLogId(MyStringUtils.getuuid());
            log.setUseId(user.getUserId());
            log.setTablename(Constant.cs_user);
            log.setTableId(user.getUserId());
            log.setOptionconent(Constant.update);
            log.setOptionip(IpUtils.getIp(request));
            int j = commonDao.insertLogD(log);
            if (j > 0) {
                ii = 1;
                return true;
            }
        }
        return false;
    }


}
