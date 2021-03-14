package com.lijinlin.project.learn.datastructureandalgorithm.SparseArray;

import ch.qos.logback.core.net.SyslogOutputStream;

public class SparseArray {
    public static void main(String[] args) {
        //1创建一个原始的二维数组 11 * 11
        //0:表示没有棋子，1表示黑子2表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转稀疏数组的思路
        //1先便利二维数组，得到非0数据的个数
        int sum = 0;
        int rowLength = chessArr1.length;
        int columnLength = chessArr1[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值 第一行 原始数组有多少行，多少列，有多少数组
        sparseArray[0][0] = rowLength;
        sparseArray[0][1] = columnLength;
        sparseArray[0][2] = sum;
        //遍历二维数组，把值放入稀疏数组
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("得到稀疏数组为~~~~~");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        //将稀疏数组恢复成原始的二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //把新的二位数组都设置成0

        //遍历稀疏数组恢复成二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复后的二维数组~~~~~");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
