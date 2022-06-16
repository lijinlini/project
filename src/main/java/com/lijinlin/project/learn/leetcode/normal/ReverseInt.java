package com.lijinlin.project.learn.leetcode.normal;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 输入：x = 123
 * 输出：321
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 输入：x = 120
 * 输出：21
 *
 * 输入：x = 0
 * 输出：0
 */
public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
        //System.out.println(2147483647 == Math.pow(2,31)-1);
    }
    public static int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x = Math.abs(x);
        }
        int result = 0;
        int digit = 0;
        while(x > 0){
            digit = x % 10;
            x = x / 10;
            if(isNegative){
                if(result >= (Math.pow(2,31) - digit)/10 ){
                    result = 0;
                    return result;
                }
            }else{
                if(result >= (Math.pow(2,31) - digit -1)/10 ){
                    result = 0;
                    return result;
                }
            }
            result = result * 10 + digit;
        }
        if(isNegative){
            result = -result;
        }
        return result;
    }
}
