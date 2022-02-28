package com.lijinlin.project.learn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));

    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * {[()]}
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Boolean result = false;
        Map<Character, Character> map = new HashMap<Character, Character>(8);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Character preChar = null;
            if(stack.size() != 0){
                preChar = stack.peek();
            }
            char curChar = charArray[i];
            if (i > 0 && map.get(preChar) != null && map.get(preChar) == curChar) {
                stack.pop();
            } else {
                stack.push(curChar);
            }
        }
        if (stack.isEmpty()) {
            result = true;
        }
        return result;
    }
}
