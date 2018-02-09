package com.mzd.drugstore.mapper.generator;

import com.mzd.drugstore.bean.generator.Commentimgs;
import com.mzd.drugstore.bean.generator.CommentimgsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentimgsMapper {
    long countByExample(CommentimgsExample example);

    int deleteByExample(CommentimgsExample example);

    int insert(Commentimgs record);

    int insertSelective(Commentimgs record);

    List<Commentimgs> selectByExample(CommentimgsExample example);

    int updateByExampleSelective(@Param("record") Commentimgs record, @Param("example") CommentimgsExample example);

    int updateByExample(@Param("record") Commentimgs record, @Param("example") CommentimgsExample example);
}