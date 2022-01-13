package com.lijinlin.project.learn.DesignPattern.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {
    /**
     * 这里我们需要Department是以数组的方式存放
     * @return
     */
    Department[] departments;
    /**
     * 遍历的位置
     */
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }
    /**判断是否还有下一个元素*/
    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    /**删除的方法默认空实现*/
    @Override
    public void remove() {
        //Iterator.super.remove();
    }
}
