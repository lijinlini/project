package com.lijinlin.project.learn.DesignPattern.bridging;

public class Client {
    public static void main(String[] args) {
        FoldedPhone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
    }
}
