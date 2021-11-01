package com.lijinlin.project.learn.DesignPattern.decorator;

public class CoffeeBar {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println("费用1 = " + order.cost());
        System.out.println("描述 = " + order.getDes());

        order = new Milk(order);
        System.out.println("order加入一份牛奶 费用 = " + order.cost());
        System.out.println("order加入一份牛奶 = " + order.getDes());

        order = new Chocolate(order);
        System.out.println("order加入一份巧克力 order加入一份牛奶 费用 = " + order.cost());
        System.out.println("order加入一份巧克力 order加入一份牛奶 = " + order.getDes());

        order = new Chocolate(order);
        System.out.println("order加入2份巧克力 order加入一份牛奶 费用 = " + order.cost());
        System.out.println("order加入2份巧克力 order加入一份牛奶 = " + order.getDes());
    }
}
