package com.lijinlin.project.learn;

public class Test2 {
    //常规单例模式
    private Sigletion sigletion = null;
    class Sigletion{

    }
    public Sigletion getSigletion() {
        //通过dcl实现
        if(sigletion == null){
            synchronized (this){
                if(sigletion == null){
                    sigletion = new Sigletion();
                    return sigletion;
                }
            }
        }
        return sigletion;
    }
}
