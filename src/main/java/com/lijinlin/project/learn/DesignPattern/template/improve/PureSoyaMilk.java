package com.lijinlin.project.learn.DesignPattern.template.improve;

public class PureSoyaMilk extends SoyaMilk{
    @Override
    void addCondiments() {
        //纯豆浆空实现
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
