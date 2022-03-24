package com.lijinlin.project.learn;

import com.lijinlin.project.pojo.Sku;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Sku> items = new ArrayList<>(30);
        Sku sku = new Sku();
        sku.setId(1);
        sku.setSkuName("1");
        sku.setSkuNum(1);
        Sku sku2 = new Sku();
        sku2.setId(1);
        sku2.setSkuName("1");
        sku2.setSkuNum(1);
        items.add(sku);
        items.add(sku2);
        /*List<Sku> employeesDisBySalary = items.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Sku::getId)))),ArrayList::new);*/
        List<Sku> unique = items.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Sku::getSkuName))), ArrayList::new)
        );
        System.out.println("sdf");
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
            if (stack.size() == 0) {
                stack.add(list[i]);
            } else {
                //不为空的时候看一下栈顶的元素是否和当前元素匹配，如果匹配就弹出，如果不匹配直接返回false;
                Character top = stack.peek();
                Character need = map.get(top);
                if (need.equals(list[i])) {
                    //匹配弹出
                    stack.pop();
                } else {
                    //不匹配继续压栈
                    stack.add(list[i]);
                }
            }

        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
