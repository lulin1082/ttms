package cn.tedu.ttms.common.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lulin
 * @Date: 3/29/2019 2:37 AM
 * @Version 1.0
 */
public class ThisCustomRealm  extends AuthorizingRealm
{
    Map<String, String> userMap = new HashMap<>(16);

    {

       //                        66f469382db2328c876b700deb336220
        userMap.put("lulin", "66f469382db2328c876b700deb336220");

        super.setName("customRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();

        Set<String> roles = getRolesByUserName(username);

        Set<String> permissions = getPermissionsByUsername(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 从主体传过来的认证信息中，获得用户名
        String username = (String) authenticationToken.getPrincipal();
        // 2. 通过用户名到数据库中获取凭证
        String password = getPasswordByUsername(username);

        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo("lulindd", "0cf2bd73603670daacf007f4b18e0c10", "customRealm");
        // 设置加密的 盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("654321"));
        return authenticationInfo;
    }

    private Set<String> getRolesByUserName(String username) {

        Set<String> set = new HashSet<>();

        // 从数据库或者缓存中获取角色数据
        set.add("admin");
        set.add("user");
        return set;
    }

    private Set<String> getPermissionsByUsername(String username) {

        Set<String> set = new HashSet<>();

        set.add("user:delete");
        set.add("user:update");
        return set;
    }

    /**
     * 模拟数据库查询凭证
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }

    public static void main(String[] args) {

        // 密码 + 盐 加密后的结果
        Md5Hash md5Hash = new Md5Hash("123123", "654321");
        System.out.println(md5Hash.toString());
        //3b8058694ec9391b001bb0463c3af161          123     salt 654321
//496edd8064892864b76c5fd3a732544b              123456      salt 654321
        //0cf2bd73603670daacf007f4b18e0c10      123123       salt 654321
    }
}
