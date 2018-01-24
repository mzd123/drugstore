package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.generator.Authority;

import java.util.List;

public interface GetAuthoritysByidsMapper {
    List<Authority> getAuthoritysByidsM(List<String> list1);
}
