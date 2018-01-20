package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Productclass;
import com.mzd.drugstore.bean.generator.ProductclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductclassMapper {
    long countByExample(ProductclassExample example);

    int deleteByExample(ProductclassExample example);

    int insert(Productclass record);

    int insertSelective(Productclass record);

    List<Productclass> selectByExample(ProductclassExample example);

    int updateByExampleSelective(@Param("record") Productclass record, @Param("example") ProductclassExample example);

    int updateByExample(@Param("record") Productclass record, @Param("example") ProductclassExample example);
}