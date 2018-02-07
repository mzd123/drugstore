package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Buy;
import com.mzd.drugstore.bean.generator.BuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyMapper {
    long countByExample(BuyExample example);

    int deleteByExample(BuyExample example);

    int insert(Buy record);

    int insertSelective(Buy record);

    List<Buy> selectByExample(BuyExample example);

    int updateByExampleSelective(@Param("record") Buy record, @Param("example") BuyExample example);

    int updateByExample(@Param("record") Buy record, @Param("example") BuyExample example);
}