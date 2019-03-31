package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.system.entity.RoleFunction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:16 AM
 * @Version 1.0
 */
@Repository

public interface RoleFunctionDao extends BaseDao<RoleFunction> {
    int saveRoleList(@Param("role_id") Long role_id, @Param("functon_id") String[] function_id );

}
