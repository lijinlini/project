package com.lijinlin.project.server.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lijinlin
 * @date2021年07月26日 10:38
 */

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect() {
        System.out.println("Aspect initialization .....LogAspect.....");
    }

    @Pointcut(value = "execution(* *(..))")
    public void requestServer(){

    }
    @Around("requestServer() && @annotation(StatsService)")
    public void doA(ProceedingJoinPoint joinPoint){
        try {
            logger.info("doA");
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
