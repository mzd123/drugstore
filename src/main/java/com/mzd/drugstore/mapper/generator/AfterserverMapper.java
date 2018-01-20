package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Afterserver;
import com.mzd.drugstore.bean.generator.AfterserverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AfterserverMapper {
    long countByExample(AfterserverExample example);

    int deleteByExample(AfterserverExample example);

    int insert(Afterserver record);

    int insertSelective(Afterserver record);

    List<Afterserver> selectByExample(AfterserverExample example);

    int updateByExampleSelective(@Param("record") Afterserver record, @Param("example") AfterserverExample example);

    int updateByExample(@Param("record") Afterserver record, @Param("example") AfterserverExample example);
}