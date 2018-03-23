package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.generator.Items;

import java.util.List;

/**
 * 商品项批处理
 */
public interface ItemsBatchMapper {
    /**
     * 根据商品项id集合获取商品项对象集合
     *
     * @param list
     * @return
     */
    List<Items> getItems_by_itemsidsM(List<String> list);
}
