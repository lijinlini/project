package com.lijinlin.project.learn.DesignPattern.sharingElement;

import java.util.HashMap;

/**
 * 图形工厂
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();
    public static Shape getCircle(String color){
        Circle circle = (Circle)circleMap.get(color);
        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of colof : " + color);
        }
        return circle;
    }
}
