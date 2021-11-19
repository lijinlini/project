package com.lijinlin.project.learn.DesignPattern.proxy.cglibProxy;

public class Client {
    public static void main(String[] args) {
        //目标对象
        TeacherDao target = new TeacherDao();
        //获取到代理对象，并且将目标对象传递给代理对象
        Object proxyInstance = new ProxyFactory(target).getProxyInstance();
        TeacherDao proxyObject = (TeacherDao)proxyInstance;
        //执行代理对象的方法，触发intecept从而实现对目标对象的调用
        String res = proxyObject.teach();

    }
}
