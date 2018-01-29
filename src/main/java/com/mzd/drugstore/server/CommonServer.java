package com.mzd.drugstore.server;

import com.alibaba.fastjson.JSONObject;
import com.mzd.drugstore.bean.backresult.RoleAuthorityUri;
import com.mzd.drugstore.bean.generator.Authority;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.Role;
import com.mzd.drugstore.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class CommonServer {
    @Autowired
    private CommonDao commonDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据角色id查询有所拥有的权限
     *
     * @param roleid
     * @return
     */
    public RoleAuthorityUri getRoleAuthorityUriByRoleidS(String roleid) {
        RoleAuthorityUri roleAuthorityUri = null;
        List list = commonDao.selectRoleByRoleidD(roleid);
        if (list != null && list.size() > 0) {
            Role role = (Role) list.get(0);
            String string = role.getAuthorityId();
            String s[] = string.split(",");
            List<Authority> list1 = commonDao.selectAuthorityByidsD(Arrays.asList(s));
            if (list1 != null && list1.size() > 0) {
                roleAuthorityUri = new RoleAuthorityUri();
                roleAuthorityUri.setRoleid(roleid);
                roleAuthorityUri.setList(list1);
                redisTemplate.opsForValue().set(roleid, JSONObject.toJSONString(roleAuthorityUri));
            }
        }
        return roleAuthorityUri;
    }

    /**
     * 对日志表的处理
     *
     * @param myLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int insertLogS(MyLog myLog) throws Exception {
        return commonDao.insertLogD(myLog);
    }
}
