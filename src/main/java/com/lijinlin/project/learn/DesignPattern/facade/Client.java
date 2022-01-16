package com.lijinlin.project.learn.DesignPattern.facade;

public class Client {
    public static void main(String[] args) {
        //不用外观模式直接调用会很麻烦

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.pause();
        homeTheaterFacade.end();
        /**
         * 外观模式在MyBatis框架应用在Configuration(外观类)去创建MetaObject
         * 外观模式屏蔽子系统得实现，提供统一接口。
         */
    }
}
