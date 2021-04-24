package com.lijinlin.project.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CreateObjectByReflection {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("com.lijinlin.project.learn.reflection.User");
        //构造一个对象 本质是调用了一个无参数构造器，如果没有无参构造器会报异常
        //User user = (User)c1.newInstance();
        //System.out.println(user);
        
        //通过构造器创建对象
       /* Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)declaredConstructor.newInstance("霖哥",001,18);
        System.out.println(user2);*/

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke:激活的意思
        //(对象，"方法的值")
        setName.invoke(user3,"萧峰");
        System.out.println(user3.getName());

        //通过反射操作属性 不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true).
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //关掉权限检测
        name.setAccessible(true);
        name.set(user4,"乔峰");
        System.out.println(user4.getName());
    }
}
