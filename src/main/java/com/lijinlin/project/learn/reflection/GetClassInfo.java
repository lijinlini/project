package com.lijinlin.project.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class GetClassInfo {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("com.lijinlin.project.learn.reflection.User");
       /* User user = new User();
        c1 = user.getClass();*/

        //获得类的名字 包名+类名
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        System.out.println("=============================");
        //只能获得类的public属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=============================");
        //获得全部类的属性
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获得指定类的属性的值
        Field nama = c1.getDeclaredField("name");
        System.out.println(nama);

        //获得类的方法
        System.out.println("=============================");
        //获得本类及其父类的全部public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
        //获得本类的所有方法
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods：" + method);
        }


    }
}
