package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.generator.Productimgs;

import java.util.List;

public interface ProductImgBatchMapper {
    int add_productimg_batch_M(List<Productimgs> list);

    int delete_productimg_batch_M(List<Productimgs> list);
}
