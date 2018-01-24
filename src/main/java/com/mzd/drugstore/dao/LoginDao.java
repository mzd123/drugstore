package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.backresult.UserWithRole;
import com.mzd.drugstore.bean.generator.Authority;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.bean.generator.UserExample;
import com.mzd.drugstore.mapper.backresult.GetAuthoritysByidsMapper;
import com.mzd.drugstore.mapper.backresult.UserWithRoleMapper;
import com.mzd.drugstore.mapper.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginDao {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserWithRoleMapper userWithRoleMapper;
    @Autowired
    private GetAuthoritysByidsMapper getAuthoritysByidsMapper;

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

    /**
     * 根据用户账号密码获取用户带角色的对象集合
     *
     * @param username
     * @param password
     * @return
     */
    public List<UserWithRole> getUserWithRole_username_userpasswordD(String username, String password) {
        return userWithRoleMapper.getUserWithRole_username_userpasswordM(username, password);
    }

    /**
     * 根据权限id集合查询权限对象集合
     *
     * @param list1
     * @return
     */
    public List<Authority> getAuthoritysByidsD(List<String> list1) {
        return getAuthoritysByidsMapper.getAuthoritysByidsM(list1);
    }
}
