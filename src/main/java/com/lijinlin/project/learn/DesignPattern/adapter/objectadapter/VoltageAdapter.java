package com.lijinlin.project.learn.DesignPattern.adapter.objectadapter;

//适配器类
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (null != voltage220V) {
            //获取220V
            int srcV = voltage220V.output220V();
            //转成5V
            dstV = srcV / 44;
        }
        return dstV;
    }
}
