package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.example.mybatis;

import java.lang.reflect.Proxy;

public class SqlSession {
    public static UserMapper getMapper(Class clazz){
        MyInvocationHandler invocationHandler = new MyInvocationHandler(clazz);
        Object proxyObject = Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), new Class[]{clazz}, invocationHandler);
        UserMapper proxy = (UserMapper) proxyObject;
        return proxy;
    }
}
