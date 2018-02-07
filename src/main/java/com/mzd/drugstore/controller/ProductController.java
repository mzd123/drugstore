package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.ProductServer;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@Api("ProductController")
public class ProductController {
    private final String api = Constant.drugstore;
    private final String authority_api = Constant.drugstore + Constant.authority;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductServer productServer;


    @RequestMapping(value = api + "select_productby_classid", method = RequestMethod.GET)
    @ApiOperation("根据商品分类id，查询该分类的所有商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "product_classid", value = "商品分类的id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pagenumber", value = "当前是第几页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pagesize", value = "一页显示多少条记录", required = true, dataType = "String", paramType = "query")
    })
    public MyResult select_productby_classid(String product_classid, String pagenumber, String pagesize) {
        try {
            if (MyStringUtils.Object2String(product_classid).equals("")) {
                return ResultUtils.getResult("400", "商品分类不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(pagenumber).equals("")) {
                return ResultUtils.getResult("400", "当前页码不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(pagesize).equals("")) {
                return ResultUtils.getResult("400", "页面大小不能为空", null, 0);
            }
            int pagenumber2 = Integer.valueOf(pagenumber);
            int pagesize2 = Integer.valueOf(pagesize);
            return productServer.select_productby_classidS(product_classid, pagenumber2, pagesize2);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = api + "select_productby_productid", method = RequestMethod.GET)
    @ApiOperation("根据商品id查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productid", value = "商品id", dataType = "String", required = true, paramType = "query")
    })
    public MyResult select_productby_productid(String productid) {
        try {
            if (MyStringUtils.Object2String(productid).equals("")) {
                return ResultUtils.getResult("400", "商品id不能为空", null, 0);
            }
            return productServer.select_productby_productidS(productid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.POST)
    @ApiOperation("增加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productName", value = "商品名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "productPrice", value = "商品价格", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "productDescription", value = "商品描述", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "productNumber", value = "商品库存", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "商品分类id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "image", value = "商品主图片", required = true, dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "images", value = "商品图片集合", required = true, dataType = "file", paramType = "query")
    })
    public MyResult add_product(String productName, String productPrice, String productDescription, String productNumber, String classId, MultipartFile image, MultipartFile[] images, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(productName).equals("")) {
                return ResultUtils.getResult("400", "商品名字不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(productPrice).equals("")) {
                return ResultUtils.getResult("400", "商品价格不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(productDescription).equals("")) {
                return ResultUtils.getResult("400", "商品描述不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(productNumber).equals("")) {
                return ResultUtils.getResult("400", "商品库存不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(classId).equals("")) {
                return ResultUtils.getResult("400", "商品分类id不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(image).equals("")) {
                return ResultUtils.getResult("400", "商品主图片不能为空", null, 0);
            }
            if (images == null || images.length == 0) {
                return ResultUtils.getResult("400", "商品图片集合不能为空", null, 0);
            }
            return productServer.add_product(productName, productPrice, productDescription, productNumber, classId, image, images, request);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = "/delete_product", method = RequestMethod.GET)
    @ApiOperation("删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productid", value = "商品id", dataType = "String", required = true, paramType = "query")
    })
    public MyResult delete_product(String productid, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(productid).equals("")) {
                return ResultUtils.getResult("400", "商品id不能为空", null, 0);
            }
            return productServer.delete_productS(productid, request);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }
}
