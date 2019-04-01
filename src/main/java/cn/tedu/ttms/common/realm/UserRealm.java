package cn.tedu.ttms.common.realm;

import cn.tedu.ttms.login.service.LoginService;
import cn.tedu.ttms.system.dao.UserRoleDao;
import cn.tedu.ttms.system.dao.UsersDao;
import cn.tedu.ttms.system.entity.User;
import cn.tedu.ttms.system.service.FunctionService;
import cn.tedu.ttms.system.service.RoleService;
import cn.tedu.ttms.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:00 AM
 * @Version 1.0
 */





public class UserRealm extends AuthorizingRealm {

    private final static Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private  LoginService loginService;


    @Resource
    UsersDao usersDao;



    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

       /* select role_name from user_roles where username = ?";
        select username,password from users where username =?";*/

        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = usersDao.findObjectByName(username);
        Long userId = user.getId();
        Set<String> functionSet = getPermissionsByUsername(userId);
        Set<String> roleSet = getRolesByUserName(userId);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.setStringPermissions(functionSet);
        return simpleAuthorizationInfo;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

     /*   UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String userName = upToken.getUsername();*/

        // 1. 从主体传过来的认证信息中，获得用户名
        String userName = (String) authenticationToken.getPrincipal();
        User user = loginService.isExist(userName);
        String pwd = user.getPassword();
        if(pwd==null){
            throw  new RuntimeException("竟然是空密码");
        }
        String salt=user.getSalt();
        /*SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, pwd, salt, getName());*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, pwd, "userRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("654321"));




/*

        SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
*/

        return authenticationInfo;
        // return info;
    }


    private Set<String> getRolesByUserName(Long id) {

        logger.info("Log从数据库中获取授权Roles数据");
        System.out.println("Log从数据库中获取授权Roles数据");
        List<String> list = usersDao.findRole(id);
        return new HashSet<String>(list);
    }

    private Set<String> getPermissionsByUsername(Long id) {
        logger.info("Log从数据库中获取授权Permission数据");
        System.out.println("Log从数据库中获取授权Permission数据");
        List<String> list = usersDao.findPermission(id);
        return new HashSet<String>(list);
    }

}
