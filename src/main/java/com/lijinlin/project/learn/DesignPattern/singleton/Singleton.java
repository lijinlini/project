package com.lijinlin.project.learn.DesignPattern.singleton;

public class Singleton {
    private static Integer ss = 12300;
    private static volatile Singleton instance;
    public Singleton(){}

    public  Singleton getInstance(){
        synchronized(ss){
            System.out.println("当前线程:"+Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(instance == null){
                instance = new Singleton();
            }
            System.out.println("我睡醒了:"+Thread.currentThread().getName());
            return instance;
        }
    }
}
