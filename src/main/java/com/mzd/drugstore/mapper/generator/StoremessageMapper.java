package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Storemessage;
import com.mzd.drugstore.bean.generator.StoremessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoremessageMapper {
    long countByExample(StoremessageExample example);

    int deleteByExample(StoremessageExample example);

    int insert(Storemessage record);

    int insertSelective(Storemessage record);

    List<Storemessage> selectByExample(StoremessageExample example);

    int updateByExampleSelective(@Param("record") Storemessage record, @Param("example") StoremessageExample example);

    int updateByExample(@Param("record") Storemessage record, @Param("example") StoremessageExample example);
}