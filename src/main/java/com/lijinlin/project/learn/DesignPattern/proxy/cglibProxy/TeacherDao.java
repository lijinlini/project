package com.lijinlin.project.learn.DesignPattern.proxy.cglibProxy;

import com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.ITeacherDao;

public class TeacherDao  {

    public String teach() {
        System.out.println(" 老师授课中，我没有实现接口");
        return "hello";
    }


}
