package com.lijinlin.project.learn.jvm;

import java.util.LinkedList;
import java.util.List;

public class OutOfMemoryTest1 {
    public static void main(String[] args) {
        List list = new LinkedList();
        for(;;){
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
