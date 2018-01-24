package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Role;
import lombok.Data;

@Data
public class UserWithRole {
    private String userId;

    private String userName;

    private String userPassword;

    private String userTel;

    private String userEmail;

    private String userCreatetime;

    private String userStatus;

    private String userRoleid;

    private Role role;


}
