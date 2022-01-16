package com.lijinlin.project.learn;

import java.io.Serializable;

public class Animal<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer legCount;

    private T value;

    public Animal(String name, Integer legCount,T value) {
        this.name = name;
        this.legCount = legCount;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLegCount() {
        return legCount;
    }

    public void setLegCount(Integer legCount) {
        this.legCount = legCount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();
        Animal animal = (Animal) deep;
        return animal;
    }
}
