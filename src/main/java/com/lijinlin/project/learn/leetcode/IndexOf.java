package com.lijinlin.project.learn.leetcode;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class IndexOf {
    public static void main(String[] args) {
        String haystack = "a", needle = "";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }
        int result = -1;
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();

        for (int i = 0; i < source.length; i++) {
            char childTarget = target[0];
            if (source[i] != childTarget) {
                continue;
            } else {
                Boolean flag = true;
                for (int j = 1; j < target.length; j++) {
                    if(target[j] == source[i + j]){
                        continue;
                    }else {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
