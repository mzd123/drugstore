package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.Product;
import com.mzd.drugstore.bean.generator.ProductExample;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.mapper.generator.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 根据条件查询商品集合
     *
     * @param product
     * @return
     */
    public List<Product> select_productD(Product product) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        //未被删除的
        criteria.andProductStatusEqualTo(Constant.liefstatus);
        if (product.getClassId() != null) {
            criteria.andClassIdEqualTo(product.getClassId());
        }
        if (product.getProductCreatetime() != null) {
            criteria.andProductCreatetimeEqualTo(product.getProductCreatetime());
        }
        if (product.getProductDescription() != null) {
            criteria.andProductDescriptionEqualTo(product.getProductDescription());
        }
        if (product.getProductId() != null) {
            criteria.andProductIdEqualTo(product.getProductId());
        }
        if (product.getProductName() != null) {
            criteria.andProductNameEqualTo(product.getProductName());
        }
        if (product.getProductPrice() != null) {
            criteria.andProductPriceEqualTo(product.getProductPrice());
        }
        if (product.getProductIfactivity() != null) {
            criteria.andProductIfactivityEqualTo(product.getProductIfactivity());
        }
        return productMapper.selectByExample(productExample);
    }
}
