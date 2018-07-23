package com.ywt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.ywt.web.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //IP
        LOGGER.info("IP={}", request.getRemoteAddr());

        //url
        LOGGER.info("url={}", request.getRequestURL());

        //method
        LOGGER.info("method={}", request.getMethod());

        //类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint
                .getSignature().getName());

        //参数
        LOGGER.info("arg[]={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        System.out.println("doAfter");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object object){
        LOGGER.info("object={}", object.toString());
    }
}
