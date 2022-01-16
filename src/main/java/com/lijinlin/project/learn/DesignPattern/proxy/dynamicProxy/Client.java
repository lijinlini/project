package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy;

import com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.TeacherDao;


public class Client {
    public static void main(String[] args) {
        //创建目标对象（被代理对象）
        ITeacherDao target = new TeacherDao();
        //创建代理对象,同时把被代理对象传递给代理对象
        ProxyFactory proxyFactory = new ProxyFactory(target);
        //生成代理类 $Proxy0
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //通过代理对象，调用到被代理对象的方法
        Object proxyInstance = proxyFactory.getProxyInstance();
        ITeacherDao proxyObject = (ITeacherDao)proxyInstance;
        //class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyObject = " + proxyObject.getClass());
        //通过代理对象，调用目标对象得方法
        //proxyObject.teach();

        proxyObject.sayHello(" tom ");
    }
}
