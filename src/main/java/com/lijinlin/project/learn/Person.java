package com.lijinlin.project.learn;

import java.io.Serializable;

public class Person<T> extends Animal<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ID;
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Person(String name,int ID,Integer legCount,T value) {
        super(name,legCount,value);
        this.ID = ID;
    }
}
