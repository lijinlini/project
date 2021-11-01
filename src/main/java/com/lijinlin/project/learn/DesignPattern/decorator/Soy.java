package com.lijinlin.project.learn.DesignPattern.decorator;

public class Soy extends Decorator{
    public Soy(Drink obj) {
        super(obj);
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
