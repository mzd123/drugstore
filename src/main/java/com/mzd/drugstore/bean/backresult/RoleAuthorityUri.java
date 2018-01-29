package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Authority;
import lombok.Data;

import java.util.List;

@Data
public class RoleAuthorityUri {
    private String roleid;
    private List<Authority> list;
}
