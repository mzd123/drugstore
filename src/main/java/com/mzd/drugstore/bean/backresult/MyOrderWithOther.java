package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Items;
import com.mzd.drugstore.bean.generator.Order;
import lombok.Data;

import java.util.List;

@Data
public class MyOrderWithOther extends Order {
    List<Items> list;
}
