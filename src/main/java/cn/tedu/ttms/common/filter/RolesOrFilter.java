package cn.tedu.ttms.common.filter;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: lulin
 * @Date: 3/27/2019 4:26 PM
 * @Version 1.0
 */
public class RolesOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {


            Subject subject = getSubject(servletRequest, servletResponse);
            String[] roles=(String[]) o;
            if(roles ==null || roles.length==0){
                return  true;
            }
            for(String role: roles){
                if(subject.hasRole(role)){
                    return true;
                }
            }

        return false;
    }
}
