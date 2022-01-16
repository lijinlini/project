package com.lijinlin.project.learn.DesignPattern.composite;

public class Department extends OrganizationComponent{
    public Department(String name, String des) {
        super(name, des);
    }

    //add，remove就不用写写了因为叶子节点不需要管理下面的节点，下面没有节点了


    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
