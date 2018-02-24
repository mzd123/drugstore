package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.mapper.generator.CommentMapper;
import com.mzd.drugstore.mapper.generator.CommentimgsMapper;
import com.mzd.drugstore.mapper.generator.ProductimgsMapper;
import com.mzd.drugstore.mapper.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentimgsMapper commentimgsMapper;

    public int update_myinfoD(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        return userMapper.updateByExample(user, userExample);
    }

    /**
     * 新增评论
     *
     * @param comment
     */
    public void insertcommentD(Comment comment) {
        commentMapper.insert(comment);
    }

    /**
     * 评论图片入库
     *
     * @param commentimgs
     */

    public void insertCommentimgsD(Commentimgs commentimgs) {
        commentimgsMapper.insert(commentimgs);
    }
}
