package com.lijinlin.project.learn.DesignPattern.proxy.cglibProxy;

public class Client {
    /**
     * 防火墙代理：内网通过代理穿透防火墙，实现对公网的访问。
     * 缓存代理：比如请求图片文件等资源时，先到缓存代理取，如果渠道资源则ok，取不到资源，再到公网或者数据库取，然后缓存。
     * 远程代理：远程对象的本地代表，通过它可以把远程对象当本地对象来调用。远程代理通过网络和真正的远程对象沟通信息。
     * 同步代理：主要使用在多线程编程中，完成多线程间同步工作。
     * @param args
     */
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
