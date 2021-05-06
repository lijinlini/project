package com.lijinlin.project.learn.reflection.test;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "你好");
    }
}
