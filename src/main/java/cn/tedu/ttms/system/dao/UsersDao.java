package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:14 AM
 * @Version 1.0
 */

@Repository
public interface UsersDao extends BaseDao<User>{

    /*
    *查询用户信息
     */
    int isExist(String name);

    /**
     * 查询用户得权限
     * @param userId
     * @return
     */
    List<String> findPermission(Long userId);
    /**
     * 查询用户的角色
     * @param userId
     * @return
     */
    List<String > findRole(Long userId);
    /**
     * 查询用户可见的菜单
     * @param id
     * @return
     */
    List<Map<String,Object>> menuList(Long id);
    User findObjectByName(String userName);


}
