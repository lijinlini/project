package com.lijinlin.project.server.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.ServletRequest;

/**
 * @author lijinlin
 * @date2021年07月26日 10:38
 */
public class LogAspect {
    @Pointcut("execution(* com.lijinlin.project.controller..*(..))")
    public void requestServer(){

    }
    @Before("requestServer()")
    public void doBefore(JoinPoint joinPoint){

    }
}
