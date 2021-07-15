package com.lijinlin.project.learn;

import com.lijinlin.project.learn.DesignPattern.singleton.Singleton;

public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread one = new MyThread();
        MyThread two = new MyThread();
        one.start();
        two.start();
        Object o = new Object();
        o.equals(1);
        int a = 1231231;
        int b = 1231231;
       /*Integer ss = 127;
       Integer aa = 127;
       System.out.print(ss == aa);*/
    }

    //2.重写run方法
    @Override
    public void run() {
        Singleton s = new Singleton();
        Singleton instatnce = s.getInstance();
        System.out.print(instatnce.hashCode());
    }
}
