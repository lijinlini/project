package com.lijinlin.project.learn.DesignPattern.visitor;

public class Wait extends Action{
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价是该歌手待定。。");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println("女人给的评价是该歌手待定。。");
    }
}
