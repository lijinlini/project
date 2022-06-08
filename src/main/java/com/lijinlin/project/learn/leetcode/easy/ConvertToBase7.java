package com.lijinlin.project.learn.leetcode.easy;

public class ConvertToBase7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-5));
    }

    /**
     * 504. 七进制数
     * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
     * input:100
     * output:202
     * 通常情况下循环比递归效率高，所以尽量第一思路使用循环，而且递归有可能会随着数据量增加出现爆炸性的计算
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = Math.abs(num);
        }
        int i = num / 7;
        int y = num % 7;
        if (i < 7) {
            if (i != 0) {
                stringBuilder.append(y).append(i);
            } else {
                stringBuilder.append(y);
            }
            if (isNegative) {
                stringBuilder.append("-");
            }
            return stringBuilder.reverse().toString();
        } else {
            if (isNegative) {
                return "-" + convertToBase7(i) + y;
            } else {
                return convertToBase7(i) + y;
            }
        }
    }

    /**
     * 官方思路
     *
     * @param num
     * @return
     */
    public static String convertToBase7Official(int num) {
        //1先判断是否是0
        if (num == 0) {
            return "0";
        }
        //2判断正负
        Boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = Math.abs(num);
        }
        //3StringBuff处理数据
        StringBuffer stringBuffer = new StringBuffer();
        //4循环 num 大于0时
        while (num > 0) {
            //5 先取余 再除自己
            stringBuffer.append(num % 7);
            num /= 7;
        }
        if(isNegative){
            stringBuffer.append("-");
        }
        return stringBuffer.reverse().toString();
    }
}
