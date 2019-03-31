package cn.tedu.ttms.common.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.Subject;
import javax.sql.DataSource;

/**
 * @Author: lulin
 * @Date: 3/27/2019 2:02 AM
 * @Version 1.0
 */
public class JdbcRealmTest {
    @Test
    public void testAuthentication(){

      /*  protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
        protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";
        protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";
        protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";
        private static final Logger log = LoggerFactory.getLogger(JdbcRealm.class);
        protected DataSource dataSource;
        protected String authenticationQuery = "select password from users where username = ?";
        protected String userRolesQuery = "select*/
        JdbcRealm jdbcRealm=new JdbcRealm();
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-pool");
        DataSource ds = ctx.getBean("ds",DataSource.class);
        // id   role_name  permission
        // 1       admin   user:select
        jdbcRealm.setDataSource(ds);
        jdbcRealm.setPermissionsLookupEnabled(true);


        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        UsernamePasswordToken token = new UsernamePasswordToken("lulin", "123456");

        org.apache.shiro.subject.Subject subject= SecurityUtils.getSubject();
        subject.checkRole("admin");
        subject.checkPermission("user:select");
    }
}
