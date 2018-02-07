package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.generator.Authority;
import com.mzd.drugstore.bean.generator.MyLog;
import com.mzd.drugstore.bean.generator.RoleExample;
import com.mzd.drugstore.mapper.backresult.AuthorityByidListMapper;
import com.mzd.drugstore.mapper.backresult.MyLogBatchMapper;
import com.mzd.drugstore.mapper.generator.MyLogMapper;
import com.mzd.drugstore.mapper.generator.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonDao {
    @Autowired
    private MyLogMapper myLogMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityByidListMapper authorityByidListMapper;
    @Autowired
    private MyLogBatchMapper myLogBatchMapper;

    /**
     * 对日志表的处理
     *
     * @param log
     * @return
     */
    public int insertLogD(MyLog log) {
        return myLogMapper.insert(log);
    }

    /**
     * 根据roleid获取role对象
     *
     * @param roleid
     * @return
     */
    public List selectRoleByRoleidD(String roleid) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleIdEqualTo(roleid);
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 根据权限id集合获取权限对象集合
     *
     * @param list
     * @return
     */
    public List<Authority> selectAuthorityByidsD(List<String> list) {
        return authorityByidListMapper.selectAuthorityByidsM(list);
    }

    /**
     * 批量处理日志
     *
     * @param list
     * @return
     */
    public int insertLogBatchD(List<MyLog> list) {
        return myLogBatchMapper.insertLogBatchM(list);
    }

}
