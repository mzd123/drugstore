package com.mzd.drugstore.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.backresult.ProductCommentAndImgs;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuy;
import com.mzd.drugstore.bean.backresult.ProductWithMonthBuyAndImgs;
import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.ProductDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.catalina.startup.ExpandWar.deleteDir;


@Service
public class ProductServer {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CommonDao commonDao;

    /**
     * 根据商品分类id查询所有商品
     *
     * @param product_classid
     * @param pagenumber2
     * @param pagesize2
     * @return
     */
    public MyResult select_productby_classidS(String product_classid, int pagenumber2, int pagesize2) {
        String product_json_str = (String) redisTemplate.opsForValue().get(Constant.productclasslist + product_classid + pagenumber2 + pagesize2);
        if (MyStringUtils.Object2String(product_json_str).equals("")) {
            PageHelper.startPage(pagenumber2, pagesize2);
            Product product = new Product();
            product.setClassId(product_classid);
            List<ProductWithMonthBuy> list = productDao.select_ProductWithMonthBuytD(product);
            PageInfo pageInfo = new PageInfo<>(list);
            //获取总记录数
            pageInfo.getTotal();
            //获取总页数--总共应该被分为多少页
            int i = pageInfo.getPages();
            //获取返回记录数
            list.size();
            //将集合存在redis中
            redisTemplate.opsForValue().set(Constant.productclasslist + product_classid + pagenumber2 + pagesize2, JSON.toJSONString(list), Constant.product_time, TimeUnit.SECONDS);
            //总共分多少页存入redis中
            redisTemplate.opsForValue().set(Constant.productclasslist + product_classid + pagenumber2 + pagesize2 + "pagenum", i, Constant.product_time, TimeUnit.SECONDS);
            return ResultUtils.getResult("200", "获取商品集合成功", list, i);
        } else {
            JSONArray jsonArray = JSON.parseArray(product_json_str);
            int i = (int) redisTemplate.opsForValue().get(Constant.productclasslist + product_classid + pagenumber2 + pagesize2 + "pagenum");
            return ResultUtils.getResult("200", "获取商品集合成功", jsonArray, i);
        }

    }


    /**
     * 根据商品id 查询该商品的所有信息
     *
     * @param productid
     * @return
     */
    public MyResult select_productby_productidS(String productid) {
        //先从redis中获取该商品信息
        String string = (String) redisTemplate.opsForValue().get(Constant.productinfo + productid);
        if (MyStringUtils.Object2String(string).equals("")) {
            //redis中没有，就去数据库中取
            Product product = new Product();
            product.setProductId(productid);
            List<ProductWithMonthBuyAndImgs> listproductWithMonthBuyAndImgs = productDao.select_productWithMonthBuyAndImgsD(product);
            if (listproductWithMonthBuyAndImgs != null && listproductWithMonthBuyAndImgs.size() > 0) {
                redisTemplate.opsForValue().set(Constant.productinfo + productid, JSON.toJSONString(listproductWithMonthBuyAndImgs), Constant.product_time, TimeUnit.SECONDS);
            }
            return ResultUtils.getResult("200", "获取商品信息成功", listproductWithMonthBuyAndImgs, 0);
        } else {
            JSONArray jsonArray = JSON.parseArray(string);
            return ResultUtils.getResult("200", "获取商品信息成功", jsonArray, 0);
        }
    }


    /**
     * 增加商品
     *
     * @param productName
     * @param productPrice
     * @param productDescription
     * @param productNumber
     * @param classId
     * @param images
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult add_product(String productName, String productPrice, String productDescription, String productNumber, String classId, MultipartFile image, MultipartFile[] images, HttpServletRequest request) throws IOException {
        String productid = MyStringUtils.getuuid();
        File file = new File(Constant.path_product + classId + "/" + productid);
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        //先将商品的主图片存入服务器
        file = new File(Constant.path_product + classId + "/" + productid + "/" + "main_" + image.getOriginalFilename());
        image.transferTo(file);
        /**
         * 先操作商品表
         */
        Product product = new Product();
        product.setClassId(classId);
        product.setProductCreatetime(TimeUtils.get_current_time());
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setProductNumber(productNumber);
        product.setProductId(productid);
        product.setProductMainImg(Constant.path_product + classId + "/" + productid + "/" + "main_" + image.getOriginalFilename());
        product.setProductStatus(Constant.liefstatus);
        int i = productDao.add_productD(product);
        List<Productimgs> list = new ArrayList<>();
        /**
         * 将图片存入服务器
         */
        for (int k = 0; k < images.length; k++) {
            String Imgid = MyStringUtils.getuuid();
            file = new File(Constant.path_product + classId + "/" + productid + "/" + Imgid + "_" + images[k].getOriginalFilename());
            images[k].transferTo(file);
            Productimgs productimgs = new Productimgs();
            productimgs.setImgid(Imgid);
            productimgs.setImgpath(Constant.path_product + classId + "/" + productid + "/" + Imgid + "_" + images[k].getOriginalFilename());
            productimgs.setImgStatus(Constant.liefstatus);
            productimgs.setProductid(productid);
            list.add(productimgs);
        }
        /**
         * 批量新增商品图片表
         */
        int j = productDao.add_productimg_batch_D(list);
        /**
         *  批量操作日志表---商品图片集合日志
         */
        List<MyLog> list1 = new ArrayList<>();
        for (int l = 0; l < list.size(); l++) {
            MyLog myLog = new MyLog();
            User user = (User) request.getSession().getAttribute("user");
            myLog.setUseId(user.getUserId());
            Productimgs productimgs = list.get(l);
            myLog.setTableId(productimgs.getImgid());
            myLog.setTablename(Constant.cs_productimgs);
            myLog.setLogId(MyStringUtils.getuuid());
            myLog.setCreatetime(TimeUtils.get_current_time());
            myLog.setOptionconent(Constant.insert);
            myLog.setOptionip("");
            list1.add(myLog);
        }
        int p = commonDao.insertLogBatchD(list1);
        //商品新增日志
        MyLog myLog = new MyLog();
        User user = (User) request.getSession().getAttribute("user");
        myLog.setUseId(user.getUserId());
        myLog.setTableId(productid);
        myLog.setTablename(Constant.cs_product);
        myLog.setLogId(MyStringUtils.getuuid());
        myLog.setCreatetime(TimeUtils.get_current_time());
        myLog.setOptionconent(Constant.insert);
        myLog.setOptionip(IpUtils.getIp(request));
        int q = commonDao.insertLogD(myLog);
        if (i > 0 && j > 0) {
            //删除redis中商品分类id为classId的所有的缓存
            redisTemplate.delete(redisTemplate.keys(Constant.productclasslist + classId + "*"));
            if (p > 0 && q > 0) {
                return ResultUtils.getResult("200", "新增商品成功", null, 0);
            } else {
                return ResultUtils.getResult("200", "新增商品成功,但数据库日志更新失败", null, 0);
            }
        }
        return ResultUtils.getResult("500", "服务器内部错误", null, 0);
    }

    /**
     * 删除商品
     *
     * @param productid
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult delete_productS(String productid, HttpServletRequest request) {
        /**
         * 先查询该id的商品存不存在
         */
        String string = (String) redisTemplate.opsForValue().get(Constant.productinfo + productid);
        ProductWithMonthBuyAndImgs productWithMonthBuyAndImgs = new ProductWithMonthBuyAndImgs();
        Product product = new Product();
        if (MyStringUtils.Object2String(string).equals("")) {
            //redis中没有，就去数据库中取
            product.setProductId(productid);
            List<ProductWithMonthBuyAndImgs> listproductWithMonthBuyAndImgs = productDao.select_productWithMonthBuyAndImgsD(product);
            if (listproductWithMonthBuyAndImgs == null || listproductWithMonthBuyAndImgs.size() == 0) {
                return ResultUtils.getResult("400", "商品id有误", null, 0);
            }
            /**
             * 确认这个商品有之后，就进行删除
             */
            productWithMonthBuyAndImgs = listproductWithMonthBuyAndImgs.get(0);
        } else {
            JSONArray jsonArray = JSON.parseArray(string);
            productWithMonthBuyAndImgs = (ProductWithMonthBuyAndImgs) jsonArray.get(0);
        }
        List<Productimgs> list = productWithMonthBuyAndImgs.getProductimgs();
        /**
         * 删除数据库中的图片集合
         */
        int i = productDao.delete_productimg_batch_D(list);
        /**
         * 删除商品表中的商品
         */
        product.setProductId(productWithMonthBuyAndImgs.getProductId());
        product.setProductMainImg(productWithMonthBuyAndImgs.getProductMainImg());
        product.setProductIfactivity(productWithMonthBuyAndImgs.getProductIfactivity());
        product.setProductStatus(Constant.deletedstatus);
        product.setProductDescription(productWithMonthBuyAndImgs.getProductDescription());
        product.setProductNumber(productWithMonthBuyAndImgs.getProductNumber());
        product.setProductPrice(productWithMonthBuyAndImgs.getProductPrice());
        product.setProductName(productWithMonthBuyAndImgs.getProductName());
        product.setProductCreatetime(productWithMonthBuyAndImgs.getProductCreatetime());
        product.setClassId(productWithMonthBuyAndImgs.getClassId());
        int j = productDao.update_productD(product);
        /**
         * 批量操作日志表
         */
        User user = (User) request.getSession().getAttribute("user");
        List<MyLog> list1 = new ArrayList<>();
        MyLog myLog = new MyLog();
        myLog.setOptionip(IpUtils.getIp(request));
        myLog.setOptionconent(Constant.delete);
        myLog.setCreatetime(TimeUtils.get_current_time());
        myLog.setLogId(MyStringUtils.getuuid());
        myLog.setTablename(Constant.cs_product);
        myLog.setUseId(user.getUserId());
        myLog.setTableId(productWithMonthBuyAndImgs.getProductId());
        list1.add(myLog);
        for (int o = 0; o < list.size(); o++) {
            myLog.setCreatetime(TimeUtils.get_current_time());
            myLog.setLogId(MyStringUtils.getuuid());
            myLog.setTablename(Constant.cs_productimgs);
            Productimgs productimgs = list.get(o);
            myLog.setTableId(productimgs.getImgid());
            list1.add(myLog);
        }
        int a = commonDao.insertLogBatchD(list1);
        if (i > 0 && j > 0) {
            /**
             *  当数据库中操作全部成功之后再去操作服务器上的图片
             *  防止出现回滚的时候，图片已经被删除了
             */
            //删除文件夹
            File file = new File(Constant.path_product + productWithMonthBuyAndImgs.getClassId() + "/" + productid);
            if (file.exists()) {
                deleteDir(file);
            }
            /**
             * 删除redis中该商品的缓存
             */
            redisTemplate.delete(redisTemplate.keys(Constant.productinfo + productid + "*"));
            /**
             * 删除该商品分类列表缓存
             */
            redisTemplate.delete(redisTemplate.keys(Constant.productclasslist + productWithMonthBuyAndImgs.getClassId() + "*"));
            if (a > 0) {
                return ResultUtils.getResult("200", "删除商品成功", null, 0);
            } else {
                return ResultUtils.getResult("200", "删除商品成功,但数据库日志更新失败", null, 0);
            }
        }
        return ResultUtils.getResult("500", "服务器内部错误", null, 0);
    }

    /**
     * 查询商品的评价
     *
     * @param productid
     * @param pagenumber
     * @param pagesize
     * @param comment_level
     * @return
     */
    public MyResult select_comment_by_productidS(String productid, String pagenumber, String pagesize, String comment_level) {
        //这里就不使用mybatis的分页插件了，因为这个东西比较蠢，每次分页条件都是写在最后的，
        // 我现在需要的是取指定个数的评论对象，而不是指定个数的评论加图片左连接之后的对象

        List<ProductCommentAndImgs> list = new ArrayList<>();
        String string = (String) redisTemplate.opsForValue().get(Constant.commentlist4productid + productid + pagenumber + pagesize);
        if (MyStringUtils.Object2String(string).equals("")) {
            list = productDao.select_comment_by_productidD(productid, pagenumber, pagesize, comment_level);
            redisTemplate.opsForValue().set(Constant.commentlist4productid + productid + pagenumber + pagesize, JSON.toJSONString(list));
        } else {
            list = JSONObject.parseArray(string, ProductCommentAndImgs.class);
        }
        //总共有多少条
        int i = 0;
        /**
         * 根据商品id查询评论总数
         */
        String commentall = (String) redisTemplate.opsForValue().get(Constant.commentall4productid + productid);
        if (MyStringUtils.Object2String(commentall).equals("")) {
            List<Comment> list1 = productDao.select_product_comment_by_productid(productid);
            if (list1 != null && list1.size() > 0) {
                i = list1.size();
            }
            /**
             * 将评论总数存入redis中
             */
            redisTemplate.opsForValue().set(Constant.commentall4productid + productid, String.valueOf(i));
        } else {
            i = Integer.valueOf(commentall);
        }
        return ResultUtils.getResult("200", "获取评价列表成功", list, i);
    }
}
