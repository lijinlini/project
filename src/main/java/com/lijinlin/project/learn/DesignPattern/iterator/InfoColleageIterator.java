package com.lijinlin.project.learn.DesignPattern.iterator;

import java.util.Iterator;
import java.util.List;


public class InfoColleageIterator implements Iterator {

    /**
     * 信息工程学院以list方式存放系
     */
    List<Department> departmentList;
    /**
     * 索引
     */
    int index = -1;

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public void remove() {
        //Iterator.super.remove();
    }

    /**
     * 判断list中有没有下一个元素
     * @return
     */
    @Override
    public boolean hasNext() {
        if(index >= departmentList.size()-1){
            return false;
        }else{
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }
}
