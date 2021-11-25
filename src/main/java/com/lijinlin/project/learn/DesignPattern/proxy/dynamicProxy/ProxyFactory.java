package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //维护一个目标对象，Object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance() {
        //一.参数说明：
        //1.loader:当前类加载器，获取加载器的方法固定
        //2.interfaces:目标对象实现的接口类型，使用泛型方法确认类型
        //3.h:事件处理，执行目标对象的方法时，会触发事件处理器方法，会把当前执行的目标对象方法作为一个参数传入
        //二.newProxyInstance方法功能
        //1.创造代理类
        //2.创造代理类中的构造方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");
                        //反射机制调用目标对象的方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("JDK代理提交");
                        return returnValue;
                    }
                });
    }
}
