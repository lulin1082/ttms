package cn.tedu.ttms.common.handler;

import cn.tedu.ttms.common.exception.ApplicationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lulin
 * @Date: 3/12/2019 2:29 PM
 * @Version 1.0
 */
public class JSPWarning {


    @ExceptionHandler
    public String handle(Exception e,
                         HttpServletRequest request){
        System.out.println("handle()");
        if(e instanceof ApplicationException){
            request.setAttribute("login_failed",
                    e.getMessage());
            return "login";
        }
        return "error";
    }
}
