package com.lijinlin.project.learn.leetcode.normal;


import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 75.60%
     * 的用户
     * 内存消耗：
     * 40.8 MB
     * , 在所有 Java 提交中击败了
     * 98.25%
     * 的用户
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer string = new StringBuffer("");
        recursion(result, string, 0, 0, n);
        return result;
    }

    /**
     * 通过递归的方式将所有可能都列出来，然后再通过条件过滤掉
     *
     * @param list   结果集 最后返回
     * @param string 存当前字符串的样子，满足条件往结果集中放
     * @param left   左括号数量
     * @param right  右括号数量
     * @param n      生成的括号数量
     */
    public static void recursion(List<String> list, StringBuffer string, Integer left, Integer right, Integer n) {
        //当右括号数量大于左括号数量则直接返回结束
        if (right > left) {
            return;
        }
        //当左右相当等并且数量等于n此时满足要求
        if (left.equals(right) && left.equals(n)) {
            list.add(string.toString());
            return;
        }
        //当左括号数量小于n数量可以继续递归
        if (left < n) {
            string.append("(");
            recursion(list, string, left +1, right, n);
            string.deleteCharAt(string.length() - 1);
        }
        //当右括号数量小于左括号
        if (right < left) {
            string.append(")");
            recursion(list, string, left, right + 1, n);
            string.deleteCharAt(string.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

}
