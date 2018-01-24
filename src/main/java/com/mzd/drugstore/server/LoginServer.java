package com.mzd.drugstore.server;

import com.mzd.drugstore.bean.backresult.UserWithRole;
import com.mzd.drugstore.bean.generator.Authority;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.LoginDao;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public int registerS(User user) {
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
    public boolean updateuserByuserNameS(User user) {
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
            int j = commonDao.insertLogD(log);
            if (j > 0) {
                ii = 1;
                return true;
            }
        }
        return false;
    }

    /**
     * 根据用户账号密码获取用户带角色的对象集合
     *
     * @param username
     * @param password
     * @return
     */
    public List<UserWithRole> getUserWithRole_username_userpasswordS(String username, String password) {
        return loginDao.getUserWithRole_username_userpasswordD(username, password);
    }

    /**
     * 根据权限id集合查询权限对象集合
     *
     * @param list1
     * @return
     */
    public List<Authority> getAuthoritysByidsS(List<String> list1) {
        return loginDao.getAuthoritysByidsD(list1);
    }
}
