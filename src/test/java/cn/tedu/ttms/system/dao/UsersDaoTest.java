package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.system.entity.User;
import cn.tedu.ttms.common.BaseDaoTest;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lulin
 * @Date: 3/28/2019 1:54 PM
 * @Version 1.0
 */
public class UsersDaoTest extends BaseDaoTest {


    @Test
    public void testFindPremission(){
        UsersDao usersDao=ctx.getBean(UsersDao.class);
        List<String> user = usersDao.findPermission((long)1);
        if(user!=null){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testFindRole(){
        UsersDao usersDao=ctx.getBean(UsersDao.class);
        List<String> user =   usersDao.findRole((long)2);
        if(user!=null){
            System.out.println(user.toString());
        }
    }



    @Test
    public void testFindNameByName(){
        UsersDao usersDao=ctx.getBean(UsersDao.class);
        User user = usersDao.findObjectByName("admin");
        if(user!=null){
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindNameById(){
        UsersDao usersDao=ctx.getBean(UsersDao.class);
        User user = usersDao.findById((long)2);
      //  System.out.println(user.toString());
    }


}