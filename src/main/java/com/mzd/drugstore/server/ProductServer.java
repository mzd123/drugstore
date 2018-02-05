package com.mzd.drugstore.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.Product;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.ProductDao;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServer {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductDao productDao;

    /**
     * 根据商品分类id查询所有商品
     *
     * @param product_classid
     * @param pagenumber2
     * @param pagesize2
     * @return
     */
    public MyResult select_productby_classidS(String product_classid, int pagenumber2, int pagesize2) {
        String product_json_str = (String) redisTemplate.opsForValue().get(product_classid + pagenumber2 + pagesize2);
        if (MyStringUtils.Object2String(product_json_str).equals("")) {
            PageHelper.startPage(pagenumber2, pagesize2);
            Product product = new Product();
            product.setClassId(product_classid);
            List<Product> list = productDao.select_productD(product);
            int i = list.size();
            if (i > 0) {
                i = (i / pagesize2) + ((i % pagesize2) == 0 ? 0 : 1);
            }
            System.out.println(JSON.toJSONString(list));
            redisTemplate.opsForValue().set(product_classid + pagenumber2 + pagesize2, JSON.toJSONString(list), Constant.product_time, TimeUnit.SECONDS);
            return ResultUtils.getResult("200", "获取商品集合成功", list, i);
        } else {
            JSONArray jsonArray = JSON.parseArray(product_json_str);
            //总共有多少页
            int i = jsonArray.size();
            if (i > 0) {
                i = (i / pagesize2) + ((i % pagesize2) == 0 ? 0 : 1);
            }
            return ResultUtils.getResult("200", "获取商品集合成功", jsonArray, i);
        }

    }
}
