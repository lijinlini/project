package com.lijinlin.project.learn.leetcode;

import java.util.Stack;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * strs = ["flower","flow","flight"]
 * "fl"
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 提交结果	执行用时	内存消耗	语言	提交时间	备注
     * 通过
     * 3 ms	40.7 MB	Java
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int rowLength = strs.length;
        StringBuilder result = new StringBuilder("");
        char[] columnChars = strs[0].toCharArray();
        int columnLength = columnChars.length;
        for (int i = 0; i < columnLength; i++) {
            Character cur = columnChars[i];
            Boolean flag = true;
            for (int j = 1; j < rowLength; j++) {
                String string = strs[j];
                String subString = "";
                try{
                    subString = string.substring(i,i+1);
                }catch (Exception e){
                    return result.toString();
                }
                char ch = subString.toCharArray()[0];
                if(cur != ch){
                    flag = false;
                }
            }
            if(flag){
                result.append(cur);
            }else{
                break;
            }
        }
        return result.toString();
    }
}
