package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.Product;
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

import java.util.List;

@RestController
@Api("ProductController")
public class ProductController {
    private final String api = Constant.drugstore;
    private final String authority_api = Constant.drugstore + Constant.authority;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductServer productServer;

    @RequestMapping(value = api + "select_product", method = RequestMethod.GET)
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
}
