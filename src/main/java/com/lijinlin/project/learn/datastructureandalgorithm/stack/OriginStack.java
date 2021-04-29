package com.lijinlin.project.learn.datastructureandalgorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OriginStack {
    public static void main(String[] args) {

        Stack<String> passwordStack1 = new Stack<>();
        passwordStack1.add("v");
        passwordStack1.add("a");
        passwordStack1.add("a");
        System.out.println(passwordStack1.search("v"));
        System.out.println(passwordStack1);

        List<String> passwordList = new ArrayList<>();
        String a = "1234567";
        String b = "123456";
        String c = "1234";
        String d = "12345";
        String e = "1234";
        String f = "12345";
        String g = "12345";
        passwordList.add(a);
        passwordList.add(b);
        passwordList.add(c);
        passwordList.add(d);
        passwordList.add(e);
        passwordList.add(f);
        passwordList.add(g);
        Stack<String> passwordStack = new Stack<>();
        for (String password : passwordList) {
            if(passwordStack.search(password) == 0){
                //找不到就添加
                passwordStack.add(password);
            }else{

            }
        }

    }
}
