package com.lijinlin.project.learn;

import java.util.HashMap;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isTrue(str));
    }

    //给定一个 字符串"(){}[]"判断字符串是否有效
    public static Boolean isTrue(String str) {
        //1定义一个栈存放字符串中的数据
        Stack<Character> stack = new Stack<>();
        //定义hashmap存放匹配的键值对。
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        //2把字符串转成list，循环压栈
        char[] list = str.toCharArray();

        for (int i = 0; i < list.length; i++) {
            //2-1如果栈是空的直接压栈，如果不为空进行校验
            if(stack.size() == 0){
                stack.add(list[i]);
            }else{
                //不为空的时候看一下栈顶的元素是否和当前元素匹配，如果匹配就弹出，如果不匹配直接返回false;
                Character top = stack.peek();
                Character need = map.get(top);
                if(need.equals(list[i])){
                    //匹配弹出
                    stack.pop();
                }else{
                    //不匹配继续压栈
                    stack.add(list[i]);
                }
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
