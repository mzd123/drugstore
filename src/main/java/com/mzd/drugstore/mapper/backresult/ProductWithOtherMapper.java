package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.backresult.ProductCommentAndImgs;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuy;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuyAndImgs;
import com.mzd.drugstore.bean.generator.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductWithOtherMapper {
    List<ProductWithMonthBuyAndImgs> select_productWithMonthBuyAndImgsM(Product product);

    List<ProductWithMonthBuy> select_ProductWithMonthBuytM(Product product);

    List<ProductCommentAndImgs> select_comment_by_productidM(@Param("productid") String productid, @Param("pagenumber") int pagenumber, @Param("pagesize") int pagesize, @Param("comment_level") int comment_level);
}
