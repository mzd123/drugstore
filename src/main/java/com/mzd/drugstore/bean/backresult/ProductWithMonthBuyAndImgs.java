package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Product;
import com.mzd.drugstore.bean.generator.Productimgs;
import lombok.Data;

import java.util.List;


@Data
public class ProductWithMonthBuyAndImgs extends ProductWithMonthBuy {
    private List<Productimgs> productimgs;
}
