package com.mzd.drugstore.controller;

import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.dictionary.MyTable;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.server.CommonServer;
import com.mzd.drugstore.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("CommnController")
public class CommnController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String api = Constant.drugstore;
    @Autowired
    private CommonServer commonServer;

    @RequestMapping(value = api + "getdictionary", method = RequestMethod.GET)
    @ApiOperation("查询数据库字典")
    public MyResult getdictionary() {
        try {
            List<MyTable> list = commonServer.getdictionaryS();
            return ResultUtils.getResult("200", "查询数据库字段成功", list, 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }
}
