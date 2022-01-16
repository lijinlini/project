package com.lijinlin.project.learn.DesignPattern.facade;
//影院灯光
public class TheaterLight {
    //使用饿汉式
    private static TheaterLight instance =new TheaterLight();

    public static  TheaterLight getInstance(){
        return instance;
    }

    public void on(){
        System.out.println(" TheaterLight on ");
    }
    public  void off(){
        System.out.println(" TheaterLight off ");
    }

    public void dim(){
        System.out.println(" TheaterLight dim ");
    }

    public void bright(){
        System.out.println(" TheaterLight bright");
    }
}
