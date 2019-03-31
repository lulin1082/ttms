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

import java.util.*;

/**
 * @Author: lulin
 * @Date: 3/27/2019 2:16 AM
 * @Version 1.0
 */
public class CustomRealm extends AuthorizingRealm {
    Map<String, String> userMap = new HashMap<>(16);

    {
        userMap.put("cheng", "66f469382db2328c876b700deb336220");

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

    private Set<String> getPermissionsByUsername(String username) {
        Set<String> set = new HashSet<>();
        set.add("user:delete");
        set.add("user:update");
        return set;
    }

    private Set<String> getRolesByUserName(String username) {
        Set<String> set = new HashSet<>();
        // 从数据库或者缓存中获取角色数据
        set.add("admin");
        set.add("user");
        return set;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        //66f469382db2328c876b700deb336220  chen 123 chen

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, "66f469382db2328c876b700deb336220", "customRealm");
        authenticationInfo.setCredentialsSalt( ByteSource.Util.bytes("654321"));

        return authenticationInfo;
    }

    private String getPasswordByUserName(String username) {
        return "lulin";
    }

    public static void main(String[] args) {
        // 密码 + 盐 加密后的结果
        String salt="123456";
        ByteSource saltStr = ByteSource.Util.bytes(salt);
        Md5Hash md5Hash = new Md5Hash("123456", saltStr);
        System.out.println(md5Hash.toString());
    }
}


