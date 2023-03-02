package com.lijinlin.project.learn.reflection;

import java.lang.reflect.Field;

//什么叫反射
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.lijinlin.project.learn.reflection.User");
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        //System.out.println(c1.hashCode());
        try{
            Field field = c1.getDeclaredField("User");
            System.out.println(field);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}

class User {
    private String name = "123456";
    private int id;
    private int age;
    protected int pro;
    public int pub;
    int def;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    private void test() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
