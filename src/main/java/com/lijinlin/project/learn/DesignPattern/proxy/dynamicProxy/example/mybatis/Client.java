package com.lijinlin.project.learn.DesignPattern.proxy.dynamicProxy.example.mybatis;

public class Client {
    public static void main(String[] args) {
        UserMapper mapper = SqlSession.getMapper(UserMapper.class);
        mapper.insert();
    }
}
