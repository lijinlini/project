package com.lijinlin.project.learn.reflection;

public class LoadingOrder {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /*
        1.加载到内存，会产生一个类对应Class对象
        2.连接，连接结束后m=0
        3.初始化<clinit>(){
            System.out.println("A类静态代码块初始化");
            m = 300;
            m = 100;
        }
        m = 100
         */
    }
}
class A{
    static int m = 100;
    static{
        System.out.println("A类静态代码块初始化" );
        m = 300;
    }

    public A(){
        System.out.println("A类无参构造初始化");
    }
}