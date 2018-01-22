package com.mzd.drugstore.server;

import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.LogDao;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServer {
    @Autowired
    private LogDao logDao;
    @Autowired
    private CommonDao commonDao;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int registerS(User user) {
        int ii = 0;
        int i = logDao.registerD(user);
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
}
