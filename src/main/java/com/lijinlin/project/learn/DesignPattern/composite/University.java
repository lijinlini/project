package com.lijinlin.project.learn.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

//University就是Compostite,可以管理college
public class University extends OrganizationComponent{
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
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
