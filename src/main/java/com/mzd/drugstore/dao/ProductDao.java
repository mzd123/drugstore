package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.backresult.ProductCommentAndImgs;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuy;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuyAndImgs;
import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.mapper.backresult.ProductImgBatchMapper;
import com.mzd.drugstore.mapper.backresult.ProductWithOtherMapper;
import com.mzd.drugstore.mapper.generator.CommentMapper;
import com.mzd.drugstore.mapper.generator.ProductMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgBatchMapper productImgBatchMapper;
    @Autowired
    private ProductWithOtherMapper productWithOtherMapper;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 根据条件查询商品集合
     *
     * @param product
     * @return
     */
    public List<ProductWithMonthBuy> select_ProductWithMonthBuytD(Product product) {
        return productWithOtherMapper.select_ProductWithMonthBuytM(product);
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
        return productWithOtherMapper.select_productWithMonthBuyAndImgsM(product);
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

    /**
     * 查看商品的评论
     *
     * @param productid
     * @param pagenumber2
     * @param pagesize2
     * @param comment_level2
     * @return
     */
    public List<ProductCommentAndImgs> select_comment_by_productidD(String productid, String pagenumber2, String pagesize2, String comment_level2) {
        int pagenumber = Integer.valueOf(pagenumber2);
        int pagesize = Integer.valueOf(pagesize2);
        int comment_level = Integer.valueOf(comment_level2);
        pagenumber = (pagenumber - 1) * pagesize;
        return productWithOtherMapper.select_comment_by_productidM(productid, pagenumber, pagesize, comment_level);
    }

    /**
     * 根据商品id查询评论集合
     *
     * @param productid
     * @return
     */
    public List<Comment> select_product_comment_by_productid(String productid) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andProductIdEqualTo(productid);
        return commentMapper.selectByExample(commentExample);
    }
}
