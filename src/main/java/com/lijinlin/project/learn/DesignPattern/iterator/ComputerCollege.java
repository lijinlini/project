package com.lijinlin.project.learn.DesignPattern.iterator;

import java.util.Iterator;

public class ComputerCollege implements College{
    Department[] departments;
    /**
     * 保存当前数组的对象个数
     */
    int numOfDepartmen = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java专业","Java专业");
        addDepartment("PHP专业","PHP专业");
        addDepartment("大数据专业","大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartmen] = department;
        numOfDepartmen += 1;

    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
