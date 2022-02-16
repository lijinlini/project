package com.lijinlin.project.learn.DesignPattern.strategy;

public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞翔技术一般");
    }
}
