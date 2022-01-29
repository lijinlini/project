package com.lijinlin.project.learn.DesignPattern.responsibilitychain;
//请求类
public class PurchaseRequest {
    /**请求类型*/
    private int type = 0;
    /**请求金额*/
    private float price = 0.0f;
    private int id = 0;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
