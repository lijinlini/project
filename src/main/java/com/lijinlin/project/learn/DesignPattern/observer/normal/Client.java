package com.lijinlin.project.learn.DesignPattern.observer.normal;

public class Client {
    /**
     * 问题分析
     * 其他第三方接入气象站获取数据的问题
     * 无法在运行时冬天的添加第三方，违反ocp原则 +》引出观察者模式
     * @param args
     */
    public static void main(String[] args) {
        //创建接入方 currentConditions
        CurrentConditions currentConditions = new CurrentConditions();
        //创建WeatherData 并将接入方currentConditions 传递到WeatherData中
        WeatherData weatherData = new WeatherData(currentConditions);

        //更新天气情况
        weatherData.setData(30,150,40);
        //天气情况变化
        System.out.println("=====================天气情况变化=======================");
        weatherData.setData(40,160,20);
    }
}
