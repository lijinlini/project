package com.lijinlin.project.learn.reflection.test;

public class HelloServiceImpl2 implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "你好");
    }
}
