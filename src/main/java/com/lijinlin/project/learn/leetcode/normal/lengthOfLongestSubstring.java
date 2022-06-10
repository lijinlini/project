package com.lijinlin.project.learn.leetcode.normal;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 采用滑动窗口的方式处理效率高
 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String  s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        //滑动窗口
        int startIndex = 0;
        int endIndex = 0;
        HashMap<Character,Integer> slidingWindow = new HashMap<>();
        int maxNum = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        for (char c : chars){
            if(slidingWindow.containsKey(c)){
                int preRepeatIndex = slidingWindow.get(c);
                if(preRepeatIndex >= startIndex){
                    startIndex = preRepeatIndex + 1;
                }
            }
            endIndex ++;
            slidingWindow.put(c,i);
            i++;
            if(endIndex - startIndex > maxNum){
                maxNum = endIndex - startIndex;
            }
        }
        return maxNum;
    }
}
