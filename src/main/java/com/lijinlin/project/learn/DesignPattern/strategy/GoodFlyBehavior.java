package com.lijinlin.project.learn.DesignPattern.strategy;

public class GoodFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞翔技术高超");
    }
}
