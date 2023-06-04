package com.lijinlin.project.learn.leetcode.normal;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 17
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    private final static String letter = "abcdefghijklmnopqrstuvwxyz";
    private static String[] getLetterByNum(int num) {
        if (num < 2 || num > 9) {
            return null;
        }
        int begin = (num - 2) * 3;
        if(num == 8){
            begin += 1;
        }
        if(num == 9){
            begin += 1;
        }
        int end = begin + 3;
        if(num == 7){
            end += 1;
        }
        if(num == 9){
            end += 1;
        }
        String str = letter.substring(begin, end);
        String[] res = str.split("");
        return res;
    }
    private static String[] getLetterByMap(String num) {
        if (num == null || Integer.valueOf(num) < 2 || Integer.valueOf(num) > 9) {
            return null;
        }
        Map<String, String> phoneMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        return phoneMap.get(num).split("");
    }
    /**
     * 23
     * abc
     */
    public static List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> resList = new ArrayList<>();
        String[] split = digits.split("");
        for (String numStr : split) {
            if(numStr == null|| numStr == ""){
                break;
            }
            String[] letters = getLetterByMap(numStr);
            if(letters == null
                    || letters.length == 0){
                break;
            }
            if (resList.size() == 0) {
                resList.addAll(Arrays.asList(letters));
            } else {
                List<String> currList = new ArrayList<>();
                for (int i = 0; i < resList.size(); i++) {
                    List<String> curList = new ArrayList<>();
                    String cur = resList.get(i);
                    for(int j = 0;j<letters.length;j++ ){
                        String a = cur + letters[j];
                        curList.add(a);
                    }
                    currList.addAll(curList);
                }
                resList.clear();
                resList.addAll(currList);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("999"));
    }
}
