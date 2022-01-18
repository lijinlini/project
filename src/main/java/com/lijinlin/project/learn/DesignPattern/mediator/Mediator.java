package com.lijinlin.project.learn.DesignPattern.mediator;

public abstract class Mediator {
    //将中介者对象加入到集合中
    public abstract void Register(String colleagueName,Colleague colleague);
    //接收一个具体的同事对象发出
    public abstract void GetMessage(int stateChange,String colleague);
    public abstract void SendMessage();
}
