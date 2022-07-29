package com.lijinlin.project.learn.Thread.scene;

/**
 * 面试题：模拟银行账户
 * 对业务写方法加索
 * 对业务读方法不加锁
 * 这样行不行
 */
public class Account {
    private String name;
    private double balance;

    public static void main(String[] args) {

        String a = null;
        System.out.println("b".equals(a));
        /*Account account = new Account();
        new Thread(()->{
            account.set("zhangsan",10);
        }).start();
        new Thread(()->{
            System.out.println(account.getBalance("zhangsan"));
        }).start();*/
    }

    private synchronized void set(String name, double balance) {
        System.out.println("name:" + name + "增加了：" + balance);
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance += balance;

    }

    private synchronized double getBalance(String name) {
        return this.balance;
    }
}
