package cn.tedu.ttms.common.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器:用于session验证
 */
public class SessionInterceptor implements HandlerInterceptor {
    private String path;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //先活动session对象

        path=request.getServletPath();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if (obj == null) {
            //如果从session对象上找不到对应的数据，说明
            //没有登录，重定向到登录页面
            response.sendRedirect("toLogin.do?path=" + path);
            return false;
        }
        //如果已经登录过,则继续向后调用
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        this.path = httpServletRequest.getRequestURI();

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(this.path);
    }
}
