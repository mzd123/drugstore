package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.backresult.ProductWithMonthBuy;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuyAndImgs;
import com.mzd.drugstore.bean.generator.Product;
import com.mzd.drugstore.bean.generator.ProductExample;
import com.mzd.drugstore.bean.generator.Productimgs;
import com.mzd.drugstore.mapper.backresult.ProductImgBatchMapper;
import com.mzd.drugstore.mapper.backresult.ProductWithMonthBuyAndImgsMapper;
import com.mzd.drugstore.mapper.backresult.ProductWithMonthBuyMapper;
import com.mzd.drugstore.mapper.generator.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
    private ProductWithMonthBuyMapper productWithMonthBuyMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgBatchMapper productImgBatchMapper;
    @Autowired
    private ProductWithMonthBuyAndImgsMapper productWithMonthBuyAndImgsMapper;

    /**
     * 根据条件查询商品集合
     *
     * @param product
     * @return
     */
    public List<ProductWithMonthBuy> select_ProductWithMonthBuytD(Product product) {
        return productWithMonthBuyMapper.select_ProductWithMonthBuytM(product);
    }

    /**
     * 新增商品
     *
     * @param product
     * @return
     */
    public int add_productD(Product product) {
        return productMapper.insert(product);
    }

    /**
     * 批量新增商品图片表
     *
     * @param list
     * @return
     */
    public int add_productimg_batch_D(List<Productimgs> list) {
        return productImgBatchMapper.add_productimg_batch_M(list);
    }


    public List<ProductWithMonthBuyAndImgs> select_productWithMonthBuyAndImgsD(Product product) {
        return productWithMonthBuyAndImgsMapper.select_productWithMonthBuyAndImgsM(product);
    }

    /**
     * 批量删除商品的图片
     *
     * @param list
     * @return
     */
    public int delete_productimg_batch_D(List<Productimgs> list) {
        return productImgBatchMapper.delete_productimg_batch_M(list);
    }

    /**
     * 修改商品
     *
     * @param product
     * @return
     */
    public int update_productD(Product product) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdEqualTo(product.getProductId());
        return productMapper.updateByExample(product, productExample);
    }
}
