package com.lijinlin.project.learn.DesignPattern.sharingElement;

/**
 * 具体的图形 圆形，实现图形接口，重写画方法，定义圆的属性
 */
public class Circle implements Shape {
    /**
     * 圆的颜色
     */
    private String color;
    /**
     * x轴坐标
     */
    private int x;
    /**
     * y轴坐标
     */
    private int y;
    /**
     * 圆半径
     */
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
        + ", x : " + x + ", y : " + y + ", radius : " + radius);
    }
}
