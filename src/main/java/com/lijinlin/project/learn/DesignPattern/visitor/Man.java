package com.lijinlin.project.learn.DesignPattern.visitor;

public class Man extends Person{
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
