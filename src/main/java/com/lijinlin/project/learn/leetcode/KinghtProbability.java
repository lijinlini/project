package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KinghtProbability {
    public static void main(String[] args) {
        double reuslt = knightProbability(3,1,0,0);
        //double s = 2/8;
        System.out.println(reuslt);
    }
    /**
     * 688. 骑士在棋盘上的概率
     *
     * @param n      棋盘行列大小
     * @param k      走路步数
     * @param row    起始行坐标
     * @param column 起始列坐标
     * @return
     */
    public static double knightProbability(int n, int k, int row, int column) {
        //在棋盘中并且一步不走则一定还在棋盘中
        if (k <= 0 && 0 <= row && row <= n - 1 && 0 <= column && column <= n - 1) {
            return 1;
        }
        //不在棋盘中并且一步不走则一定不在棋盘中
        if (k <= 0 && (row > n - 1 || row < 0 || column > n - 1 || column < 0)) {
            return 0;
        }
        //每一步只有8个格子可以走 递归的思路
        double in = 8;
        if (row - 2 < 0 || column - 1 < 0 || row - 2 > n - 1 || column - 1 > n - 1) {
            in--;
        }
        if (row - 1 < 0 || column - 2 < 0 || row - 1 > n - 1 || column - 2 > n - 1) {
            in--;
        }
        if (row + 1 < 0 || column - 2 < 0 || row + 1 > n - 1 || column - 2 > n - 1) {
            in--;
        }
        if (row + 2 < 0 || column - 1 < 0 || row + 2 > n - 1 || column - 1 > n - 1) {
            in--;
        }
        if (row - 2 < 0 || column + 1 < 0 || row - 2 > n - 1 || column + 1 > n - 1) {
            in--;
        }
        if (row - 1 < 0 || column + 2 < 0 || row - 1 > n - 1 || column + 2 > n - 1) {
            in--;
        }
        if (row + 1 < 0 || column + 2 < 0 || row + 1 > n - 1 || column + 2 > n - 1) {
            in--;
        }
        if (row + 2 < 0 || column + 1 < 0 || row + 2 > n - 1 || column + 1 > n - 1) {
            in--;
        }
        double curResult = in / 8.0;
        if(k > 0){
            //每一步都是8分之一的概率，所以每一次都乘以0.125
            double curResult1 = 0.125 * knightProbability(n, k - 1, row - 2, column - 1);
            double curResult2 = 0.125 * knightProbability(n, k - 1, row - 1, column - 2);
            double curResult3 = 0.125 * knightProbability(n, k - 1, row + 1, column - 2);
            double curResult4 = 0.125 * knightProbability(n, k - 1, row + 2, column - 1);
            double curResult5 = 0.125 * knightProbability(n, k - 1, row - 2, column + 1);
            double curResult6 = 0.125 * knightProbability(n, k - 1, row - 1, column + 2);
            double curResult7 = 0.125 * knightProbability(n, k - 1, row + 1, column + 2);
            double curResult8 = 0.125 * knightProbability(n, k - 1, row + 2, column + 1);
            curResult = curResult1 + curResult2 + curResult3 + curResult4 + curResult5 + curResult6 + curResult7 + curResult8;
        }
        return curResult;
    }
}
