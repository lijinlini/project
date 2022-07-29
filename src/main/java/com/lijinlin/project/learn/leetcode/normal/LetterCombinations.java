package com.lijinlin.project.learn.leetcode.normal;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if(getLetterByNum(Integer.valueOf(numStr)) == null
                    || getLetterByNum(Integer.valueOf(numStr)).equals("")){
                break;
            }
            String[] tem = getLetterByNum(Integer.valueOf(numStr));
            if (resList.size() == 0) {
                resList.addAll(Arrays.asList(tem));
            } else {
                List<String> currList = new ArrayList<>();
                for (int i = 0; i < resList.size(); i++) {
                    List<String> curList = new ArrayList<>();
                    String cur = resList.get(i);
                    for(int j = 0;j<tem.length;j++ ){
                        String a = cur + tem[j];
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
