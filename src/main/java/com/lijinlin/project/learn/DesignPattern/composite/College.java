package com.lijinlin.project.learn.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent{
    //list中存放的是department
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //将来实际业务中，College的add和University add不一定完全一样
        organizationComponentList.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    //输出University包含的学院
    @Override
    protected void print() {
        System.out.println("----------" + getName() + "--------------");
        for(OrganizationComponent organizationComponent : organizationComponentList){
            organizationComponent.print();
        }
    }
}
