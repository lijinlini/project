package com.lijinlin.project.learn.leetcode.normal;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeViolence(s));
    }

    /**
     * 暴力解法
     * 时间复杂度 O(n^3) n为字符串的长度
     * 空间复杂度 O(1),只用到常数个临时变量
     *
     * @param s
     * @return
     */
    public static String longestPalindromeViolence(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        //回文串的最大长度
        int maxLength = 1;
        //回文串最大长度对应的起始位置
        int begin = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && validPalindromic(charArray,i,j)){
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin,begin + maxLength);
    }

    /**
     * 验证子串 s[left..right]是否为回文串
     */
    private static boolean validPalindromic(char[] charArray, int left, int rigth) {
        while (left < rigth) {
            if (charArray[left] != charArray[rigth]) {
                return false;
            }
            left++;
            rigth--;
        }
        return true;
    }
}
