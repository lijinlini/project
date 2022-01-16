package com.lijinlin.project.learn.DesignPattern.observer.normal.improve;

import com.lijinlin.project.learn.DesignPattern.observer.normal.CurrentConditions;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions = new CurrentConditions();
        weatherData.registerObserver(currentConditions);
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(baiduSite);

        weatherData.removerObserver(currentConditions);
        System.out.println("通知各个注册的观察者");
        weatherData.setData(10f,100f,30.3f);


    }
}
