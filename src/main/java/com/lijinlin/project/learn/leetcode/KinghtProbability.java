package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KinghtProbability {
    /**
     *
     * @param n 棋盘行列大小
     * @param k 走路步数
     * @param row 起始行坐标
     * @param column 起始列坐标
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        //在棋盘中并且一步不走则一定还在棋盘中
        if(k <= 0 && row <= n-1 && column <= n-1){
            return 1;
        }
        //不在棋盘中并且一步不走则一定不在棋盘中
        if(k <= 0 && (row > n-1 || column > n-1)){
            return 0;
        }
        //设置棋盘
        int[][] checkBoard = new int[n-1][n-1];
        //保存每一步的可能性
        List<Double> possibilityList = new ArrayList<>(64);
        //计算每一步的可能性最后相乘 递归的思路


        return 0.0;
    }
}
