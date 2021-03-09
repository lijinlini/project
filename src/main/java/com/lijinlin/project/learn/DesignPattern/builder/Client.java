package com.lijinlin.project.learn.DesignPattern.builder;

public class Client {
    public static void main(String[] args) {
        //StringBuilder是建造者模式
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子
        House house = houseDirector.constructHouse();
        System.out.println("--------------------");
        //盖高楼
        HighBuilding highBuilding = new HighBuilding();
        houseDirector.setHouseBuilder(highBuilding);
        House house1 = houseDirector.constructHouse();
    }
}
