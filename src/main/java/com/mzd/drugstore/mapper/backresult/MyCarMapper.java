package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.backresult.Mycar;

import java.util.List;

public interface MyCarMapper {
    //查询我的购物车
    List<Mycar> select_my_carM(String userId);
}
