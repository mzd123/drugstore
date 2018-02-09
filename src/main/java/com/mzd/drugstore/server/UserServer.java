package com.mzd.drugstore.server;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.UserDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;

@Service
public class UserServer {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommonDao commonDao;

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

    public int add_commentS(User user, String productid, String commentContent, MultipartFile[] imgs) {
        return 0;
    }
}
