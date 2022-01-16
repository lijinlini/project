package com.lijinlin.project.learn.DesignPattern.decorator;

public class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        //自己的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return des + " " + getPrice() + " && " + obj.getDes();
    }
}
