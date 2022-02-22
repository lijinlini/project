package com.lijinlin.project.learn.leetcode;


public class Palindrome {
    public static void main(String[] args) {
        int x = 1;
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
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        //保存回文的数值
        int reverseNum = 0;
        while (x % 10 >= 0) {
            if (reverseNum > 0) {
                reverseNum = reverseNum * 10 + x % 10;
            } else {
                reverseNum = x % 10;
            }
            if(x > 9){
                x = (x - x % 10) / 10;
            }
            if (reverseNum >= x) {
                break;
            }
        }
        if (x == reverseNum) {
            return true;
        } else {
            if (reverseNum - reverseNum % 10 == x * 10 && x != 0 && reverseNum % 10 != 0) {
                return true;
            }
            return false;
        }
    }
}
