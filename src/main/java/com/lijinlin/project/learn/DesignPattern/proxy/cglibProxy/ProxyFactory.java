package com.lijinlin.project.learn.DesignPattern.proxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//把方法拦截住然后进行增强
public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;
    //传入一个被代理的对象
    public ProxyFactory(Object target) {
        this.target = target;
    }
    //返回一个代理对象，target的代理对象
    public  Object getProxyInstance(){
        //1创建一个工具类 增强器
        Enhancer enhancer = new Enhancer();
        //2设置父类
        enhancer.setSuperclass(target.getClass());
        //3设置回调函数
        enhancer.setCallback(this);
        //4创建子类对象，即代理对象
        return enhancer.create();
    }

    //重写 intercept方法，会调用目标对象的方法

    /**
     *
     * @param o this,the enhanced object 表示增强的对象，即实现这个接口类的一个对象； teacherDao
     * @param method 表示要被拦截的方法；teach()
     * @param args 表示要被拦截方法的参数；这里没有参数
     * @param methodProxy used to invoke super 当前执行方法的代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理模式~~开始");
        Object returnValue = method.invoke(target, args);
        System.out.println("cglib代理模式~~提交");
        return returnValue;
    }
}
