package com.lijinlin.project.learn.leetcode;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "110";
        String b = "1";
        System.out.println(addBinaryOfficial(a, b));
    }
    public static String addBinaryOfficial(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = aLength > bLength ? aLength : bLength;
        int addNum = 0;
        StringBuilder result = new StringBuilder("");
        while (aLength != 0 || bLength != 0 || addNum != 0) {
            int a1 = 0;
            if (aLength == maxLength) {
                a1 = Integer.valueOf(String.valueOf(a.charAt(aLength - 1)));
            } else {
                if(aLength > 0){
                    a1 = Integer.valueOf(String.valueOf(a.charAt(aLength - 1)));
                }
            }
            if(aLength > 0){
                aLength = --aLength;
            }
            int b1 = 0;
            if (bLength == maxLength) {
                b1 = Integer.valueOf(String.valueOf(b.charAt(bLength - 1)));
            }else{
                if(bLength > 0){
                    b1 = Integer.valueOf(String.valueOf(b.charAt(bLength - 1)));
                }
            }
            if(bLength > 0){
                bLength = --bLength;
            }
            int curNum = a1 + b1 + addNum;
            addNum = 0;
            if (curNum - 2 == 1) {
                curNum = 1;
                addNum = 1;
            }
            if (curNum - 2 == 0) {
                curNum = 0;
                addNum = 1;
            }
            result.append(curNum);
        }
        return result.reverse().toString();
    }
}
