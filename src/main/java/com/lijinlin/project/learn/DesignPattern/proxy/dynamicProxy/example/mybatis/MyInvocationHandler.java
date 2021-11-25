package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.example.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object realObj;

    public MyInvocationHandler(Object realObj) {
        this.realObj = realObj;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 真实类要执行的方法
     * @param args 真实类需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK代理开始");
        //反射机制调用目标对象的方法
        //Object returnValue = method.invoke(realObj, args);
        Insert annotation = method.getAnnotation(Insert.class);
        String sql = annotation.value();
        System.out.println(sql);
        System.out.println("JDK代理提交");
        return null;
    }
}
