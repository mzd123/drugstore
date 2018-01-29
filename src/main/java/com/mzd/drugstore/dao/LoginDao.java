package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.bean.generator.UserExample;
import com.mzd.drugstore.mapper.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginDao {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public int registerD(User user) {
        return userMapper.insert(user);
    }

    /**
     * 根据用户信息查用户集合
     *
     * @param user
     * @return
     */
    public List SelectuserListD(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user != null) {
            if (user.getUserId() != null) {
                criteria.andUserNameEqualTo(user.getUserId());
            }
            if (user.getUserCreatetime() != null) {
                criteria.andUserCreatetimeEqualTo(user.getUserCreatetime());
            }
            if (user.getUserEmail() != null) {
                criteria.andUserEmailEqualTo(user.getUserEmail());
            }
            if (user.getUserName() != null) {
                criteria.andUserNameEqualTo(user.getUserName());
            }
            if (user.getUserTel() != null) {
                criteria.andUserTelEqualTo(user.getUserTel());
            }
            if (user.getUserStatus() != null) {
                criteria.andUserStatusEqualTo(user.getUserStatus());
            }
            if (user.getUserPassword() != null) {
                criteria.andUserPasswordEqualTo(user.getUserPassword());
            }
            if (user.getUserRoleid() != null) {
                criteria.andUserRoleidEqualTo(user.getUserRoleid());
            }
            return userMapper.selectByExample(userExample);
        }
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public int updateuserByuserNameD(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user != null) {
            if (user.getUserName() != null) {
                criteria.andUserNameEqualTo(user.getUserName());
            }
            return userMapper.updateByExample(user, userExample);
        }
        return 0;
    }

}
