package com.lijinlin.project.learn.DesignPattern.decorator;

public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
