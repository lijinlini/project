package com.lijinlin.project.learn.DesignPattern.strategy;

public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();
        pekingDuck.setFlyBehavior(new GoodFlyBehavior());
        pekingDuck.fly();
    }
}
