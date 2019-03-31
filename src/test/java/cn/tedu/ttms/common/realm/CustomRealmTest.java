package cn.tedu.ttms.common.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: lulin
 * @Date: 3/29/2019 1:51 AM
 * @Version 1.0
 */
public class CustomRealmTest {

  SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("f2f", "111", "admin", "user");
    }

    @Test
    public void testAuthentication() {

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("f2f", "111");
        subject.login(token);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

        // 检查用户是否有 admin 角色
        subject.checkRoles("admin", "user");

        // 退出认证
        subject.logout();

        System.out.println("isAuthenticated: " + subject.isAuthenticated());
    }



    @Test
    public void testAuthentication1() {

        CustomRealm customRealm = new CustomRealm();

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        // 加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 加密算法名称
        matcher.setHashAlgorithmName("md5");
        // 加密次数
        matcher.setHashIterations(1);

        // 自定义 Realm 中设置加密对象
        customRealm.setCredentialsMatcher(matcher);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("chen", "123");
        subject.login(token);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

        subject.checkRole("admin");
//
        subject.checkPermission("user:delete");
        subject.checkPermission("user:update");
    }

     @Test
    public void getPwd(){
        String salt="cheng";
        ByteSource saltStr = ByteSource.Util.bytes(salt);
       System.out.println(saltStr);
         Md5Hash md5Hash = new Md5Hash("123", saltStr);
         System.out.println(md5Hash.toString());
      //  NjU0MzIx
      //  496edd8064892864b76c5fd3a732544b
         //496edd8064892864b76c5fd3a732544b
     }



}