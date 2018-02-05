package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.Productclass;
import com.mzd.drugstore.bean.generator.ProductclassExample;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.mapper.generator.ProductclassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClassDao {
    @Autowired
    private ProductclassMapper productclassMapper;

    /**
     * 查询商品分类
     *
     * @return
     */
    public List<Productclass> select_product_classD(Productclass productclass) {
        ProductclassExample productclassExample = new ProductclassExample();
        ProductclassExample.Criteria criteria = productclassExample.createCriteria();
        //未被删除的
        criteria.andProductclassStatusEqualTo(Constant.liefstatus);
        if (productclass.getProductclassId() != null) {
            criteria.andProductclassIdEqualTo(productclass.getProductclassId());
        }
        if (productclass.getProductclassName() != null) {
            criteria.andProductclassNameEqualTo(productclass.getProductclassName());
        }
        return productclassMapper.selectByExample(productclassExample);
    }

    /**
     * 修改商品分类
     *
     * @param productclass
     * @return
     */
    public int update_product_classD(Productclass productclass) {
        ProductclassExample productclassExample = new ProductclassExample();
        ProductclassExample.Criteria criteria = productclassExample.createCriteria();
        criteria.andProductclassIdEqualTo(productclass.getProductclassId());
        return productclassMapper.updateByExample(productclass, productclassExample);
    }

    /**
     * 新增商品分类
     *
     * @param productclass
     * @return
     */
    public int add_product_classD(Productclass productclass) {
        return productclassMapper.insert(productclass);
    }

    /**
     * 删除商品分类
     *
     * @param productclass
     * @return
     */
    public int delete_product_classD(Productclass productclass) {
        ProductclassExample productclassExample = new ProductclassExample();
        ProductclassExample.Criteria criteria = productclassExample.createCriteria();
        criteria.andProductclassIdEqualTo(productclass.getProductclassId());
        return productclassMapper.deleteByExample(productclassExample);
    }
}
