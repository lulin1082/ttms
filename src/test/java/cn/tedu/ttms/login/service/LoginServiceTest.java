package cn.tedu.ttms.login.service;

import cn.tedu.ttms.common.BaseDaoTest;
import cn.tedu.ttms.system.entity.User;
import cn.tedu.ttms.system.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: lulin
 * @Date: 3/28/2019 9:03 PM
 * @Version 1.0
 */
public class LoginServiceTest extends BaseDaoTest {

    @Test
    public void exist(){
        LoginService loginService=ctx.getBean(LoginService.class);
        User u = loginService.isExist("admin");
        System.out.println(u.toString());
    }

}