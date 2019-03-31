package cn.tedu.ttms.login.service.impl;

import cn.tedu.ttms.login.service.LoginService;
import cn.tedu.ttms.system.dao.UsersDao;
import cn.tedu.ttms.system.entity.User;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lulin
 * @Date: 3/25/2019 1:32 AM
 * @Version 1.0
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UsersDao userDao;

    @Override
    public User isExist(String username) {
        if (username == null) {
            throw new NullPointerException("name 不能为空");
        }
        User user = userDao.findObjectByName(username);
        if (user != null) {
            System.out.println(user.toString());
            return user;
        }
            throw new UnknownAccountException("Account 不存在");

    }}
