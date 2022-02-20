package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KinghtProbability {
    public static void main(String[] args) {
        double reuslt = knightProbability(8,30,6,4);
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
        if (k <= 0 || row > n - 1 || row < 0 || column > n - 1 || column < 0) {
            return 0;
        }
        //每一步只有8个格子可以走 递归的思路
        double in = 0;
        if (row - 2 >= 0 && column - 1 >= 0 && row - 2 <= n - 1 && column - 1 <= n - 1) {
            //在范围内0
            in++;
        }
        if (row - 1 >= 0 && column - 2 >= 0 && row - 1 <= n - 1 && column - 2 <= n - 1) {
            in++;
        }
        if (row + 1 >= 0 && column - 2 >= 0 && row + 1 <= n - 1 && column - 2 <= n - 1) {
            in++;
        }
        if (row + 2 >= 0 && column - 1 >= 0 && row + 2 <= n - 1 && column - 1 <= n - 1) {
            in++;
        }
        if (row - 2 >= 0 && column + 1 >= 0 && row - 2 <= n - 1 && column + 1 <= n - 1) {
            in++;
        }
        if (row - 1 >= 0 && column + 2 >= 0 && row - 1 <= n - 1 && column + 2 <= n - 1) {
            in++;
        }
        if (row + 1 >= 0 && column + 2 >= 0 && row + 1 <= n - 1 && column + 2 <= n - 1) {
            in++;
        }
        if (row + 2 >= 0 && column + 1 >= 0 && row + 2 <= n - 1 && column + 1 <= n - 1) {
            in++;
        }
        double curResult = in / 8.0;
        if(k > 1){
            double nextResult = 1;
            //每一步都是8分之一的概率，所以每一次都乘以0.125
            double curResult1 = knightProbability(n, k - 1, row - 2, column - 1);
            double curResult2 = knightProbability(n, k - 1, row - 1, column - 2);
            double curResult3 = knightProbability(n, k - 1, row + 1, column - 2);
            double curResult4 = knightProbability(n, k - 1, row + 2, column - 1);
            double curResult5 = knightProbability(n, k - 1, row - 2, column + 1);
            double curResult6 = knightProbability(n, k - 1, row - 1, column + 2);
            double curResult7 = knightProbability(n, k - 1, row + 1, column + 2);
            double curResult8 = knightProbability(n, k - 1, row + 2, column + 1);
            if(curResult1 != 0){
                nextResult = curResult1;
            }
            if(curResult2 != 0){
                nextResult = curResult2;
            }
            if(curResult3 != 0){
                nextResult = curResult3;
            }
            if(curResult4 != 0){
                nextResult = curResult4;
            }
            if(curResult5 != 0){
                nextResult = curResult5;
            }
            if(curResult6 != 0){
                nextResult = curResult6;
            }if(curResult7 != 0){
                nextResult = curResult7;
            }
            if(curResult8 != 0){
                nextResult = curResult8;
            }

            curResult = nextResult * curResult;
        }
        return curResult;
    }
}
