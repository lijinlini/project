package com.lijinlin.project.learn.DesignPattern.observer.normal.improve;

import com.lijinlin.project.learn.DesignPattern.observer.normal.CurrentConditions;

import java.util.ArrayList;

/**
 * 核心类
 * 1：包含最新天气情况信息
 * 2：含有观察者集合，使用arrayList管理
 * 3：当数据有更新时，遍历arrayList,通知所有的接入方看到最新消息
 */
public class WeatherData implements Subject{
    /**
     *     温度，气压,湿度
     */
    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange(){
        /**
         * 调用接入方的update
         */
        notifyObservers();
    }

    /**
     * 当数据有更新时，就调用setData
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange,将最新的信息推送给接入方的currentConditions
        dataChange();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(getTemperature(),getPressure(),getHumidity());
        }
    }
}
