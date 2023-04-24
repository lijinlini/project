package com.lijinlin.project.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    /**
     * 118
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *  *      *
     *      *      *                   1
     *      *      *                  1 1
     *      *      * @param numRows  1 2 1
     *      *      * @return        1 3 3 1
     *      *      *               1 4 6 4 1
     */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        //上一行
        List<Integer> preLine = new ArrayList<>();
        //先构建外层
        for (int i = 1; i <= numRows; i++) {
            //当前行
            List<Integer> curLine = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (preLine.size() == 0) {
                    curLine.add(1);
                    break;
                }
                int curNum;
                //这个数是他左上方和右上方的数的和
                if (j == 0 || j == i - 1) {
                    curNum = 1;
                } else {
                    curNum = preLine.get(j - 1) + preLine.get(j);
                }
                curLine.add(curNum);
            }
            preLine = curLine;
            resultList.add(curLine);
        }
        return resultList;
    }
}
