package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 我的购物车
 */
@Data
public class Mycar {
    private String itemsId;

    //订单id，没有下单只加入购物车的话，是没有订单id的
    private String orderId;
    //商品数量
    private String productNumber;

    private String userId;

    private String itemsMoney;
    //是否被删除
    private String itemsStatus;

    private List<Product> productList;
    //库存是否够
    private String ifhave;
}
