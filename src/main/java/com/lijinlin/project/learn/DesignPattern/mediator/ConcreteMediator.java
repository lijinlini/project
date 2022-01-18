package com.lijinlin.project.learn.DesignPattern.mediator;

import java.util.HashMap;
//具体的中介者类
public class ConcreteMediator extends Mediator{
    private HashMap<String,Colleague> colleagueMap;
    private HashMap<String,String> interMap;


    public ConcreteMediator(HashMap<String, Colleague> colleagueMap, HashMap<String, String> interMap) {
        this.colleagueMap = colleagueMap;
        this.interMap = interMap;
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName,colleague);
        if(colleague instanceof Alarm){
            interMap.put("Alarm",colleagueName);
        }else if(colleague instanceof TV){
            interMap.put("TV",colleagueName);
        }
    }

    //具体中介者的核心方法
    //1根据得到消息，完成对应任务
    //2中介者在这个方法，协调各个具体的同事对象，完成任务
    @Override
    public void GetMessage(int stateChange, String colleagueName) {
        if(colleagueMap.get(colleagueName) instanceof Alarm){
            if(stateChange == 0){
                ((Alarm)colleagueMap.get(interMap.get("Alarm"))).sendAlarm(0);
            }
        }else if(colleagueMap.get(colleagueName) instanceof TV){
            ((TV)colleagueMap.get(interMap.get("Alarm"))).sendTV(1);
        }
    }

    @Override
    public void SendMessage() {

    }
}
