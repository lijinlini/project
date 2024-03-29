package com.lijinlin.project.learn.leetcode.easy;


import com.alibaba.druid.sql.visitor.functions.Char;

public class Palindrome {
    public static void main(String[] args) {
        int x = 123321;
        System.out.println(isPalindrome1(x));
    }

    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 例如，121 是回文，而 123 不是。
     * 输入：x = 121
     * 输出：true
     * 执行时间 7ms 内存消耗40MB左右
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String x1 = String.valueOf(x);
        char[] chars = x1.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x == 0 || x <= 9) {
            return true;
        }
        //保存回文的数值
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < chars.length;i++){
            if(Character.isLetterOrDigit(chars[i])){
                stringBuffer.append(Character.toLowerCase(chars[i]));
            }
        }
        int right = stringBuffer.length() - 1;
        int left = 0;
        boolean result = true;
        while(right > left){
            if (stringBuffer.charAt(right) != stringBuffer.charAt(left)){
                result = false;
                break;
            }
            right--;
            left++;
        }
        return result;
    }
}
