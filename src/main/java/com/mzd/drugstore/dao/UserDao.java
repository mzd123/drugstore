package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.bean.generator.UserExample;
import com.mzd.drugstore.mapper.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public int update_myinfoD(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        return userMapper.updateByExample(user, userExample);
    }
}
