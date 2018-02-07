package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.backresult.ProductWithMonthBuyAndImgs;
import com.mzd.drugstore.bean.generator.Product;

import java.util.List;


public interface ProductWithMonthBuyAndImgsMapper {


    List<ProductWithMonthBuyAndImgs> select_productWithMonthBuyAndImgsM(Product product);
}
