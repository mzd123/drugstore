package com.mzd.drugstore.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mzd.drugstore.bean.generator.Productclass;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.ProductDao;
import com.mzd.drugstore.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServer {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductDao productDao;

    /**
     * 查询商品分类
     *
     * @return
     */
    public List<Productclass> select_product_classS(Productclass productclass) {
        List<Productclass> list = new ArrayList<>();
        String array_str = (String) redisTemplate.opsForValue().get(Constant.productclass);
        if (MyStringUtils.Object2String(array_str).equals("")) {
            list = productDao.select_product_classD(productclass);
            if (list != null && list.size() > 0) {
                //将查询结果存入redis中
                redisTemplate.opsForValue().set(Constant.productclass, JSON.toJSONString(list), Constant.productclass_time, TimeUnit.SECONDS);
            }
            return list;
        } else {
            JSONArray jsonArray = JSON.parseArray(array_str);
            list = jsonArray.toJavaList(Productclass.class);
            return list;
        }
    }

    /**
     * 修改商品分类
     *
     * @param productclass
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update_product_classS(Productclass productclass) throws Exception {
        int i = productDao.update_product_classD(productclass);
        if (i > 0) {
            //删除redis中商品分类的缓存
            redisTemplate.delete(Constant.productclass);
        }
        return i;
    }

    /**
     * 新增商品分类
     *
     * @param productclass
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int add_product_classS(Productclass productclass) throws Exception {
        int i = productDao.add_product_classD(productclass);
        if (i > 0) {
            //删除redis中商品分类的缓存
            redisTemplate.delete(Constant.productclass);
        }
        return i;
    }
}
