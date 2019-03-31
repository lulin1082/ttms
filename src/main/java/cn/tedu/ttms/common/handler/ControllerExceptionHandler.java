package cn.tedu.ttms.common.handler;

import cn.tedu.ttms.common.aspect.HttpAspect;
import cn.tedu.ttms.common.exception.ApplicationException;
import cn.tedu.ttms.common.exception.AutoException;
import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.common.web.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(Exception e){
        return new JsonResult(e);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult handleException(RuntimeException e){

        if(e instanceof AutoException){
            AutoException autoException=(AutoException) e;
            return new JsonResult(autoException.getCode(),e);
//            return new ResultBean(e):
        }

        return new JsonResult(e);
    }



}
