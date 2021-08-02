package com.lijinlin.project.learn.dataStructureAndAlgorithm.stack;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedStackDemo {
    //使用链表模拟栈
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(2);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了");
    }
}

class LinkedListStack {
    private int top = -1;
    private int maxSize;
    private LinkedList<Integer> stack;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new LinkedList<Integer>();
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //压栈push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack.add(top, value);
    }

    //出栈，将栈顶的数据返回
    public int pop() {
        //先判断是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack.get(top);
        top--;
        return value;
    }

    //遍历栈的情况，便利时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]:%d\n", i, stack.get(i));
        }
    }
}
