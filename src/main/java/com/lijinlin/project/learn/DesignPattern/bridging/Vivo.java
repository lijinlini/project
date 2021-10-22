package com.lijinlin.project.learn.DesignPattern.bridging;

public class Vivo implements Brand{
    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机呼叫");
    }
}
