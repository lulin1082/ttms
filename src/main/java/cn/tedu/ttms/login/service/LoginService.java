package cn.tedu.ttms.login.service;

import cn.tedu.ttms.system.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: lulin
 * @Date: 3/25/2019 1:32 AM
 * @Version 1.0
 */

@Service("loginService")
public interface LoginService {


    /**
     * 根据用户名判断用户是否存在
     * @param username
     * @return
     */
    User isExist(String username);


}
