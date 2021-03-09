package com.lijinlin.project.learn.DesignPattern.builder;

public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子建墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子建屋顶");
    }

}
