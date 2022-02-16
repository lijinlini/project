package com.lijinlin.project.learn.DesignPattern.strategy;

public class PekingDuck extends Duck{
    public PekingDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" 这是北京鸭 ");
    }
}
