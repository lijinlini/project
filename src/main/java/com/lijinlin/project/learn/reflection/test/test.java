package com.lijinlin.project.learn.reflection.test;

import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws Exception {
        HelloService service2 = new HelloServiceImpl2();
        Method method = HelloService.class.getMethod("sayHello", String.class);
        Object ret = method.invoke(service2,"李四");
        System.out.println(ret);
    }
}
