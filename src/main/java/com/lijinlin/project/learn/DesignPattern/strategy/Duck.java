package com.lijinlin.project.learn.DesignPattern.strategy;

public abstract class Duck {
    //属性，策略接口
    FlyBehavior flyBehavior;
    //也可以有其他属性

    public Duck() {
    }

    public abstract  void display();
    public void quack(){
        System.out.println("鸭子嘎嘎叫");
    }
    public void swim(){
        System.out.println("鸭子会游泳");
    }
    public void fly(){
        if(flyBehavior != null){
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
