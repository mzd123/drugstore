package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.bean.generator.UserExample;
import com.mzd.drugstore.mapper.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogDao {
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
}
