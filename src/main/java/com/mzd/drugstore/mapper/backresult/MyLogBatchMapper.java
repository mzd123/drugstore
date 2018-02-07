package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.generator.Authority;
import com.mzd.drugstore.bean.generator.MyLog;

import java.util.List;

public interface MyLogBatchMapper {
    int insertLogBatchM(List<MyLog> list);
}
