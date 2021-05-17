package com.lijinlin.project.learn.Thread.threadLocal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args) {
        ThreadLocal<String> str = new ThreadLocal<>();
        ArrayList<String> list = new ArrayList<String>();
        try{
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
                System.out.println("线程1："+list.get(0));
            }).start();
            System.out.println("线程0Size："+list.size());

            Thread.sleep(1000 * 1);

            new Thread(() -> {
                System.out.println("线程2："+list.get(0));
                list.add(Thread.currentThread().getName());
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

