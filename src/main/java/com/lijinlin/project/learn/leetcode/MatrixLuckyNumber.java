package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MatrixLuckyNumber {
    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][4];
        matrix2[0][0] = 1;
        matrix2[0][1] = 10;
        matrix2[0][2] = 4;
        matrix2[0][3] = 2;
        matrix2[1][0] = 9;
        matrix2[1][1] = 3;
        matrix2[1][2] = 8;
        matrix2[1][3] = 7;
        matrix2[2][0] = 15;
        matrix2[2][1] = 16;
        matrix2[2][2] = 17;
        matrix2[2][3] = 12;
        //List<Integer> b = luckyNumbers(matrix2);


        int[][] matrix3 = new int[2][2];
        matrix3[0][0] = 7;
        matrix3[0][1] = 8;
        matrix3[1][0] = 1;
        matrix3[1][1] = 2;
        List<Integer> c = luckyNumbers(matrix3);
        System.out.println(c);

    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        int numLine = matrix.length;
        int numColumn = matrix[0].length;
        int[] numMinLineArray = new int[numLine];
        for(int i = 0; i < numLine; i++ ){
            //同一行中最小
            int numLineMin = matrix[i][0];
            for(int j = 0; j < numColumn; j++ ){
                //当前数
                int numCur = matrix[i][j];
                if(numCur <= numLineMin){
                    numLineMin = numCur;
                }
            }
            numMinLineArray[i] = numLineMin;
        }
        int[] numMaxColumnArray = new int[numColumn];
        for(int i = 0; i < numColumn; i++ ){
            //同一列中最大
            int numColumnMax = matrix[0][i];
            for(int j = 0; j < numLine; j++ ){
                //当前数
                int numCur = matrix[j][i];
                if(numCur >= numColumnMax){
                    numColumnMax = numCur;
                }
            }
            numMaxColumnArray[i] = numColumnMax;
        }
        List<Integer> result = new ArrayList<>(1);
        for(int i = 0 ; i < numMinLineArray.length;i++){
            for(int j = 0; j < numMaxColumnArray.length; j++ ){
                if(numMinLineArray[i] == numMaxColumnArray[j]){
                    result.add(numMinLineArray[i]);
                }
            }
        }
        return result;
    }
}
