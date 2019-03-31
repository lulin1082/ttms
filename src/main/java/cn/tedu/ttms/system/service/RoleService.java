package cn.tedu.ttms.system.service;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.system.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:25 PM
 * @Version 1.0
 */
@Service
public interface RoleService {

     Map<String,Object>  findObjects(Role role, PageObject pageObj);

    List<Map<String,Object>> loadMenuTree();

    void save(Role role, String menuIdList);

    Map<String,Object> findRoleById(Long roleId);

    void updateRole(Role role, String menuIdList);

    void deleteRole(Long roleId);
}
