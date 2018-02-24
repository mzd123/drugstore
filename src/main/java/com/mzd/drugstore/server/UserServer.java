package com.mzd.drugstore.server;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.ProductDao;
import com.mzd.drugstore.dao.UserDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServer {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommonDao commonDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult update_myinfoS(User user) {
        int i = userDao.update_myinfoD(user);
        if (i > 0) {
            /**
             * 操作日志表
             */
            MyLog myLog = new MyLog();
            myLog.setTableId(user.getUserId());
            myLog.setUseId(user.getUserId());
            myLog.setTablename(Constant.cs_user);
            myLog.setLogId(MyStringUtils.getuuid());
            //获取request
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            myLog.setOptionip(IpUtils.getIp(request));
            myLog.setOptionconent(Constant.update);
            myLog.setCreatetime(TimeUtils.get_current_time());
            int k = commonDao.insertLogD(myLog);
            if (k > 0) {
                return ResultUtils.getResult("200", "修改用户信息成功", null, 0);
            }
            return ResultUtils.getResult("200", "修改用户信息成功,但日志更新失败", null, 0);
        } else {
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    /**
     * 添加评论
     *
     * @param user
     * @param productid
     * @param commentContent
     * @param imgs
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int add_commentS(User user, String productid, String commentContent, MultipartFile[] imgs, String commentLevel) throws Exception {

        /**
         * 操作评论表
         */
        Comment comment = new Comment();
        comment.setCommentContent(commentContent);
        comment.setProductId(productid);
        comment.setCommentCreatetime(TimeUtils.get_current_time());
        comment.setUserId(user.getUserId());
        comment.setCommentStatus(Constant.liefstatus);
        comment.setCommentId(MyStringUtils.getuuid());
        //评论等级- - - 默认是中等评价
        if (MyStringUtils.Object2String(commentLevel).equals("")) {
            commentLevel = "3";
        }
        comment.setCommentLevel(commentLevel);
        /**
         * 保存评论
         */
        userDao.insertcommentD(comment);
        /**
         * 操作日志表
         */
        MyLog myLog = new MyLog();
        myLog.setCreatetime(TimeUtils.get_current_time());
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        myLog.setOptionip(IpUtils.getIp(request));
        myLog.setLogId(MyStringUtils.getuuid());
        myLog.setTableId(comment.getCommentId());
        myLog.setTablename(Constant.cs_comment);
        myLog.setUseId(user.getUserId());
        myLog.setOptionconent(Constant.insert);
        commonDao.insertLogD(myLog);

        /**
         * 将图片存入服务器中
         */
        if (imgs != null && imgs.length > 0) {
            File file = new File(Constant.path_comment + user.getUserId() + "/" + productid);
            if (!file.exists()) {
                //不存在目录就创建
                file.mkdirs();
            }
            List<Commentimgs> list = new ArrayList<>();
            for (int i = 0; i < imgs.length; i++) {
                String imgid = MyStringUtils.getuuid();
                File file1 = new File(Constant.path_comment + user.getUserId() + "/" + productid + "/" + imgid + "_" + imgs[i].getOriginalFilename());
                imgs[i].transferTo(file1);
                Commentimgs commentimgs = new Commentimgs();
                commentimgs.setImgid(imgid);
                commentimgs.setImgpath(Constant.path_comment + user.getUserId() + "/" + productid + "/" + imgid + "_" + imgs[i].getOriginalFilename());
                commentimgs.setImgStatus(Constant.liefstatus);
                commentimgs.setCommentid(comment.getCommentId());
                list.add(commentimgs);
            }
            for (int i = 0; i < list.size(); i++) {
                /**
                 * 将评论图片入库 - - - 数量不多，就不单独写批处理了
                 */
                Commentimgs commentimgs = list.get(i);
                userDao.insertCommentimgsD(commentimgs);
                myLog = new MyLog();
                myLog.setCreatetime(TimeUtils.get_current_time());
                myLog.setOptionip(IpUtils.getIp(request));
                myLog.setLogId(MyStringUtils.getuuid());
                myLog.setTableId(commentimgs.getImgid());
                myLog.setTablename(Constant.cs_commentimgs);
                myLog.setUseId(user.getUserId());
                myLog.setOptionconent(Constant.insert);
                commonDao.insertLogD(myLog);
            }
        }
        /**
         * 删除redis中的缓存数据
         */
        redisTemplate.delete(redisTemplate.keys(Constant.commentlist4productid + productid + "*"));
        redisTemplate.delete(redisTemplate.keys(Constant.commentall4productid + productid + "*"));
        return 1;
    }
}
