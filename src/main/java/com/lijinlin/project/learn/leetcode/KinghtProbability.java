package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 * <p>
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 */
public class KinghtProbability {
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};


    public static void main(String[] args) {
        // 11341432  68036840
        double reuslt = knightProbability(8, 8, 3, 0);
        //double reuslt1 = knightProbability1(8, 9, 3, 0);
        System.out.println(reuslt);
        //System.out.println(reuslt1);
    }

    public static double knightProbability1(int n, int k, int row, int column) {
        //步数 行 列
        double[][][] piece = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        piece[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                //说明当前点的周围8个点之一在范围内
                                piece[step][i][j] += piece[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return piece[k][row][column];
    }


    static class Key{
        public int k;
        public int row;
        public int column;

        public Key(int k, int row, int column) {
            this.k = k;
            this.row = row;
            this.column = column;
        }
    }

    private static Map<Key,Double> memeory = new HashMap<>(512);

    private static int count = 0;
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
        System.out.println(count++);
        //不在棋盘中并且一步不走则一定不在棋盘中
        if (row > n - 1 || row < 0 || column > n - 1 || column < 0) {
            return 0;
        }
        //在棋盘中并且一步不走则一定还在棋盘中
        if (k <= 0) {
            return 1;
        }
        Key key = new Key(k,row,column);
        if(memeory.containsKey(key)){
            return memeory.get(key);
        }
        double result = 0;
        double curResult1 = knightProbability(n, k - 1, row - 2, column - 1);
        double curResult2 = knightProbability(n, k - 1, row - 1, column - 2);
        double curResult3 = knightProbability(n, k - 1, row + 1, column - 2);
        double curResult4 = knightProbability(n, k - 1, row + 2, column - 1);
        double curResult5 = knightProbability(n, k - 1, row - 2, column + 1);
        double curResult6 = knightProbability(n, k - 1, row - 1, column + 2);
        double curResult7 = knightProbability(n, k - 1, row + 1, column + 2);
        double curResult8 = knightProbability(n, k - 1, row + 2, column + 1);
        result = curResult1 + curResult2 + curResult3 + curResult4 + curResult5 + curResult6 + curResult7 + curResult8;
        memeory.put(key,result / 8);
        return result / 8;
    }
}
