package com.lijinlin.project.learn.DesignPattern.flyweight;

public class ConcreteWebSite extends WebSite{
    //网站发布的形式（类型）
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为：" + type + " " + user.getName() + "在使用");
    }
}
