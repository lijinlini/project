package com.lijinlin.project.learn;

public class Animal {
    private String name;
    private Integer legCount;

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
    protected Object clone() throws CloneNotSupportedException{
        Object deep = null;
        deep = super.clone();
        Animal animal = (Animal)deep;
        return animal;
    }
}
