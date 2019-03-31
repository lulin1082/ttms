package cn.tedu.ttms.common.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
/**
 * @Author: lulin
 * @Date: 3/9/2019 9:32 PM
 * @Version 1.0
 *  <aop:aspectj-autoproxy/>
 *  <aop:aspectj-autopoxy/>
 */




@Aspect
@Component
public class HttpAspect {

  private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
   // @Before(pointcut="execution(public * cn.tedu.ttms.*.controller.*(..))")
    @Before("execution(public * cn.tedu.ttms.*.controller.*(..))")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        System.out.println("22");
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("args={}",joinPoint.getArgs());





    }

    @AfterReturning(returning="o",pointcut="execution(public * cn.tedu.ttms.login.controller.LoginController.*(..))")
    public void doAfterReturning(Object o) {
        logger.info("response={}",o+"-=-"+o.toString());
        System.out.println("11");
    }

    @After("execution(public * cn.tedu.ttms.login.controller.LoginController.*(..))")
    public void doAfter() {
        System.out.println("11");
    }


  /*  private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * cn.tedu.ttms.*.controller.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("222222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
*/


}
