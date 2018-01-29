package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.Productclass;
import com.mzd.drugstore.bean.generator.User;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.CommonServer;
import com.mzd.drugstore.server.ProductServer;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api("ProductController")
public class ProductController {
    //不需要权限的uri
    private final String api = Constant.drugstore;
    //受权限控制的uri
    private final String authority_api = Constant.drugstore + Constant.authority;
    @Autowired
    private ProductServer productServer;
    @Autowired
    private CommonServer commonServer;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = api + "select_product_class", method = RequestMethod.GET)
    @ApiOperation("查询商品分类")
    public MyResult select_product_class() {
        try {
            Productclass productclass = new Productclass();
            List<Productclass> list = productServer.select_product_classS(productclass);
            return ResultUtils.getResult("200", "查询商品分类成功", list, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    //受权限控制
    @RequestMapping(value = authority_api + "update_product_class", method = RequestMethod.GET)
    @ApiOperation("修改商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productclassid", value = "商品类id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "productclassname", value = "商品名字", required = true, dataType = "Stirng", paramType = "query")
    })
    public MyResult update_product_class(String productclassid, String productclassname, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(productclassid).equals("")) {
                return ResultUtils.getResult("400", "商品id不能为空", null, 0);
            }
            if (MyStringUtils.Object2String(productclassname).equals("")) {
                return ResultUtils.getResult("400", "商品名字不能为空", null, 0);
            }
            Productclass productclass = new Productclass();
            productclass.setProductclassId(productclassid);
            productclass.setProductclassName(productclassname);
            int i = productServer.update_product_classS(productclass);
            if (i > 0) {
                MyLog myLog = new MyLog();
                myLog.setCreatetime(TimeUtils.get_current_time());
                myLog.setTablename(Constant.productclass);
                myLog.setLogId(MyStringUtils.getuuid());
                myLog.setOptionconent(Constant.update);
                myLog.setTableId(productclassid);
                User user = (User) request.getSession().getAttribute("user");
                myLog.setUseId(user.getUserId());
                int ii = commonServer.insertLogS(myLog);
                if (ii > 0) {
                    return ResultUtils.getResult("200", "修改商品分类成功", null, 0);
                }
                return ResultUtils.getResult("200", "修改商品分类成功，但更新日志失败", null, 0);
            }
            return ResultUtils.getResult("500", "修改商品分类失败", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    @RequestMapping(value = authority_api + "add_product_class", method = RequestMethod.GET)
    @ApiOperation("增加商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productclassname", value = "商品分类名字", dataType = "Stirng", required = true, paramType = "query")
    })
    public MyResult add_product_class(String productclassname, HttpServletRequest request) {
        try {
            if (MyStringUtils.Object2String(productclassname).equals("")) {
                return ResultUtils.getResult("400", "商品名字不能为空", null, 0);
            }
            Productclass productclass = new Productclass();
            productclass.setProductclassName(productclassname);
            productclass.setProductclassId(MyStringUtils.getuuid());
            int i = productServer.add_product_classS(productclass);
            if (i > 0) {
                MyLog myLog = new MyLog();
                myLog.setCreatetime(TimeUtils.get_current_time());
                myLog.setTablename(Constant.productclass);
                myLog.setLogId(MyStringUtils.getuuid());
                myLog.setOptionconent(Constant.insert);
                myLog.setTableId(productclass.getProductclassId());
                User user = (User) request.getSession().getAttribute("user");
                myLog.setUseId(user.getUserId());
                int ii = commonServer.insertLogS(myLog);
                if (ii > 0) {
                    return ResultUtils.getResult("200", "增加商品分类成功", null, 0);
                }
                return ResultUtils.getResult("200", "增加商品分类成功，但更新日志失败", null, 0);
            }
            return ResultUtils.getResult("500", "增加商品分类失败", null, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }
}
