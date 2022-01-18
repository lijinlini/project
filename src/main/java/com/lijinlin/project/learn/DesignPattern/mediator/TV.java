package com.lijinlin.project.learn.DesignPattern.mediator;

public class TV extends Colleague{
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        /**
         * 在创建alarm 同事对象时，将自己放入到concreteMediator对象中
         */
        mediator.Register(name,this);
    }

    public void sendTV(int stateChange){
        sendMessage(stateChange);
    }
    @Override
    public void sendMessage(int stateChange) {
        //调用中介者的getMessage
        this.GetMediator().GetMessage(stateChange,this.name);
    }
}
