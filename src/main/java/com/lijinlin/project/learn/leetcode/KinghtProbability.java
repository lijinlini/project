package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KinghtProbability {
    /**
     * @param n      棋盘行列大小
     * @param k      走路步数
     * @param row    起始行坐标
     * @param column 起始列坐标
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        //在棋盘中并且一步不走则一定还在棋盘中
        if (k <= 0 && row <= n - 1 && column <= n - 1) {
            return 1;
        }
        //不在棋盘中并且一步不走则一定不在棋盘中
        if (k <= 0 && (row > n - 1 || column > n - 1)) {
            return 0;
        }
        double everyPossibility = 8;
        //保存每一步的可能性
        List<Double> possibilityList = new ArrayList<>(64);
        //每一步只有8个格子可以走 递归的思路
        int notIn = 0;
        for (int i = 0; i < 7; i++) {
            if (row - 2 < 0 || column - 1 < 0 || row - 2 > n - 1 || column - 1 > n - 1) {
                knightProbability(n, k - 1, row - 2, column - 1);
                notIn++;
            }
            if (row - 1 < 0 || column - 2 < 0 || row - 1 > n - 1 || column - 2 > n - 1) {
                knightProbability(n, k - 1, row - 1, column - 2);
                notIn++;
            }
            if (row + 1 < 0 || column - 2 < 0 || row + 1 > n - 1 || column - 2 > n - 1) {
                knightProbability(n, k - 1, row + 1, column - 2);
                notIn++;
            }
            if (row + 2 < 0 || column - 1 < 0 || row + 2 > n - 1 || column - 1 > n - 1) {
                knightProbability(n, k - 1, row + 2, column - 1);
                notIn++;
            }
            if (row - 2 < 0 || column + 1 < 0 || row - 2 > n - 1 || column + 1 > n - 1) {
                knightProbability(n, k - 1, row - 2, column + 1);
                notIn++;
            }
            if (row - 1 < 0 || column + 2 < 0 || row - 1 > n - 1 || column + 2 > n - 1) {
                knightProbability(n, k - 1, row - 1, column + 2);
                notIn++;
            }
            if (row + 1 < 0 || column + 2 < 0 || row + 1 > n - 1 || column + 2 > n - 1) {
                knightProbability(n, k - 1, row + 1, column + 2);
                notIn++;
            }
            if (row + 2 < 0 || column + 1 < 0 || row + 2 > n - 1 || column + 1 > n - 1) {
                knightProbability(n, k - 1, row + 2, column + 1);
                notIn++;
            }
        }
        double curResult = (8 - notIn) / 8;


        return 0.0;
    }
}
