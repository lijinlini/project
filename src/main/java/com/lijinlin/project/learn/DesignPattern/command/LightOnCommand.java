package com.lijinlin.project.learn.DesignPattern.command;

public class LightOnCommand implements Command{
    //聚会LightReceiver
    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        light.on();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        light.off();
    }
}
