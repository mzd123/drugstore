package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.mapper.generator.MyLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonDao {
    @Autowired
    private MyLogMapper myLogMapper;

    /**
     * 系统操作日志
     *
     * @param log
     * @return
     */
    public int insertLogD(MyLog log) {
        return myLogMapper.insert(log);
    }
}
