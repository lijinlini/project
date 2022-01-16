package com.lijinlin.project.learn.DesignPattern.observer.normal.improve;

//观察者接口，由观察者实现
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
