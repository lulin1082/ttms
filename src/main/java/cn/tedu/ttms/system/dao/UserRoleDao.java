package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.system.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:14 AM
 * @Version 1.0
 */
@Repository
public interface UserRoleDao extends BaseDao<UserRole>{
    int isExist(@Param("roleId")Long roleId);
    Set<String> findRolesByUserId(@Param("userId")Long userId);

}
