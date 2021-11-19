package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy;

import com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.ITeacherDao;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" 老师授课中。。。");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello" + name);
    }
}
