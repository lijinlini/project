package com.lijinlin.project.learn.DesignPattern.observer.normal;

/**
 * 核心类
 * 1：包含最新天气情况信息
 * 2：含有CurrentConditions
 * 3：当数据有更新时，就主动的调用 CurrentConditions对象的update方法（含有display）,这样他们（接入方）就看到最新的信息
 */
public class WeatherData {
    /**
     *     温度，气压,湿度
     */
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
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
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
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

}
