package com.lijinlin.project.learn.DesignPattern.adapter.interfaceAdapter;

public class Client {
    public static void main(String[] args) {
        /**
         * 使用匿名内部类的方法去覆盖接口的方法
         */
        AbsAdapter adapter = new AbsAdapter(){
            @Override
            public void m1() {
                System.out.println("m1");
            }
        };
        adapter.m1();
    }
}
