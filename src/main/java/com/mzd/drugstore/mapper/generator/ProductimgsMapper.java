package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Productimgs;
import com.mzd.drugstore.bean.generator.ProductimgsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductimgsMapper {
    long countByExample(ProductimgsExample example);

    int deleteByExample(ProductimgsExample example);

    int insert(Productimgs record);

    int insertSelective(Productimgs record);

    List<Productimgs> selectByExample(ProductimgsExample example);

    int updateByExampleSelective(@Param("record") Productimgs record, @Param("example") ProductimgsExample example);

    int updateByExample(@Param("record") Productimgs record, @Param("example") ProductimgsExample example);
}