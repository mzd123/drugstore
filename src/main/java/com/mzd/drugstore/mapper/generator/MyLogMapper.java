package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.MyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyLogMapper {
    long countByExample(MyLogExample example);

    int deleteByExample(MyLogExample example);

    int insert(MyLog record);

    int insertSelective(MyLog record);

    List<MyLog> selectByExample(MyLogExample example);

    int updateByExampleSelective(@Param("record") MyLog record, @Param("example") MyLogExample example);

    int updateByExample(@Param("record") MyLog record, @Param("example") MyLogExample example);
}