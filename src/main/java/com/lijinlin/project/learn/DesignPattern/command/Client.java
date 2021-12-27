package com.lijinlin.project.learn.DesignPattern.command;

public class Client {
    public static void main(String[] args) {
        //使用命令设计模式，完成通过遥控器，对电灯得操作
        //创建电灯得对象（接收者）
        LightReceiver lightReceiver = new LightReceiver();
    }
}
