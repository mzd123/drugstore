package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.backresult.ProductWithMonthBuy;
import com.mzd.drugstore.bean.generator.Product;

import java.util.List;

public interface ProductWithMonthBuyMapper {

    List<ProductWithMonthBuy> select_ProductWithMonthBuytM(Product product);
}
