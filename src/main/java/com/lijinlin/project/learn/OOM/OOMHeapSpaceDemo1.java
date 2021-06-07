package com.lijinlin.project.learn.OOM;

/**
 * @author lijinlin
 * @date2021年06月07日 15:24
 */
public class OOMHeapSpaceDemo1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            stringBuilder.append(System.currentTimeMillis());
        }
    }
}
