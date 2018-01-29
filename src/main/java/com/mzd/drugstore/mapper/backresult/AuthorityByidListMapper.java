package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.generator.Authority;

import java.util.List;

public interface AuthorityByidListMapper {
    List<Authority> selectAuthorityByidsM(List<String> list);
}
