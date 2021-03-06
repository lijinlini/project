package com.lijinlin.project.learn.DesignPattern.adapter.classadapter;

//适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        //获取220V
        int srcV = output220V();
        //转成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
