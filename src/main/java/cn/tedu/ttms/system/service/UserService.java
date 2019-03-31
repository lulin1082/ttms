package cn.tedu.ttms.system.service;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:25 PM
 * @Version 1.0
 */
@Service
public interface UserService {

    Map<String, Object> findObjects(User user, PageObject pageObject);

    List<Map<String,Object>> findRoleList();

    void saveUser(User user, String roleIdList);

    Map<String,Object> findUserById(Long userId);

    void updateUser(User user, String roleIdList);

    void changeState(Long userId, Integer valid);

     List<String> findPermission(Long userId);
    List<Map<String, Object>> menuList();

    List<String> findRole(Long id);

    User findUserByName(String name);
}
