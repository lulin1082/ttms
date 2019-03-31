package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.system.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:16 AM
 * @Version 1.0
 */
@Repository
public interface RoleDao extends BaseDao<Role> {
    List<Map<String, Object>> findRoleList();
}
