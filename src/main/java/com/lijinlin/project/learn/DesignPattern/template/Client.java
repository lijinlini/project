package com.lijinlin.project.learn.DesignPattern.template;

public class Client {
    public static void main(String[] args) {
        //ConfigurableApplicationContext refresh()方法就是模板模式

        //制作红豆豆浆
        System.out.println("---制作红豆豆浆---");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        System.out.println("---制作花生豆浆---");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}
