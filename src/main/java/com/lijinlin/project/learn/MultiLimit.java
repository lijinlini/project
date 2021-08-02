package com.lijinlin.project.learn;

public class MultiLimit implements MultiLimitInterfaceA, MultiLimitInterfaceB {


    public static <T extends MultiLimitInterfaceA & MultiLimitInterfaceB> void test1(T t) {

    }
}

interface MultiLimitInterfaceA {
}

interface MultiLimitInterfaceB {
}