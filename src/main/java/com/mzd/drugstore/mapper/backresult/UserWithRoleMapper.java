package com.mzd.drugstore.mapper.backresult;

import com.mzd.drugstore.bean.backresult.UserWithRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWithRoleMapper {
    List<UserWithRole> getUserWithRole_username_userpasswordM(@Param("username") String username, @Param("password") String password);
}
