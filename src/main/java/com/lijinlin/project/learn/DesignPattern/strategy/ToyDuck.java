package com.lijinlin.project.learn.DesignPattern.strategy;

public class ToyDuck extends Duck{
    public ToyDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是玩具鸭 ");
    }
}
