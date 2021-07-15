package com.lijinlin.project.learn.dataStructureAndAlgorithm.stack;

public class Calculator {
    /**
     * 使用栈完成表达式的计算思路
     * 7*2*2-5+1-5+3-4=？
     * 1通过一个index来便利表达式
     * 2如果发现是一个数字直接入数栈
     * 3如果发现是一个符号就分如下情况
     * 3.1如果发现当前的符号栈为空，就直接入栈
     * 3.2如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，
     * 再从符号栈pop出一个符号，进行运算，将得到的结果，入数栈，然后将当前的操作符入符号栈，
     * 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
     * 4当表达式扫描完毕，就顺序的从数栈中pop出相应的数和符号，并运行。
     * 5最后在数栈只有一个数字，就是表达式的结果
     */
    public static void main(String[] args) {
        String expression = "21+2*6-2";
        //创建两个栈，数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //用户扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描得到char保存到ch
        char ch = ' ';
        //用于拼接多位数
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么类型，做相应处理
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                //如果是数，直接入栈
                keepNum += ch;
                //先判断是否是最后一位是最后一位就不处理
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //考虑两位的情况需要往后探一位看是否还是数字
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {

                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }

        }


        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = numStack.cal(num1, num2, operStack.pop());
            numStack.push(res);
        }
        System.out.printf("%s=%d", expression, res);
    }

}

//先创建一个栈，直接使用之前基于数组的栈
class ArrayStack2 {
    //栈的大小
    private int maxSize;
    //数组模拟栈，数据就放在该数组中
    private int[] stack;
    //top表示栈顶，初始没有数据所以是-1
    private int top = -1;
    //构造器


    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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
        //先判断栈是否满了
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int peek() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top];
    }

    //出栈，将栈顶的数据返回
    public int pop() {
        //先判断是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
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
            System.out.printf("stack[%d]:%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定的，优先级使用数字表示
    //数字越大，则优先级越高
    public int priority(int oper) {
        //oper是操作符
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//假定目前的表达式只有加减乘除
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        //用于存放计算结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
