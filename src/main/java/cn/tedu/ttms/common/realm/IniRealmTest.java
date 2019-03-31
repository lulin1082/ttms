package cn.tedu.ttms.common.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author: lulin
 * @Date: 3/27/2019 1:33 AM
 * @Version 1.0
 */
public class IniRealmTest {

    @Test
    public void test() {


        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        System.out.println(iniRealm.getIni());
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        UsernamePasswordToken token = new UsernamePasswordToken("lulin", "123456");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        subject.checkRole("admin");
        subject.checkPermission("user:update");

  /* // Subject currentUser = SecurityUtils.getSubject( );
    boolean remeberMe;
        if(!currentUser.isAuthenticated()){
        UsernamePasswordToken token = new UsernamePasswordToken(username,usepwd);
        currentUser.login(token);
    }*/
        subject.logout();
    }

}
