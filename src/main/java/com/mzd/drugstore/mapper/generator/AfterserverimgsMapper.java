package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Afterserverimgs;
import com.mzd.drugstore.bean.generator.AfterserverimgsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AfterserverimgsMapper {
    long countByExample(AfterserverimgsExample example);

    int deleteByExample(AfterserverimgsExample example);

    int insert(Afterserverimgs record);

    int insertSelective(Afterserverimgs record);

    List<Afterserverimgs> selectByExample(AfterserverimgsExample example);

    int updateByExampleSelective(@Param("record") Afterserverimgs record, @Param("example") AfterserverimgsExample example);

    int updateByExample(@Param("record") Afterserverimgs record, @Param("example") AfterserverimgsExample example);
}