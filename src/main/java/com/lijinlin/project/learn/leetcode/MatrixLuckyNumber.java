package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MatrixLuckyNumber {
    public static void main(String[] args) {


    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int numLine = matrix.length;
        int numColumn = matrix[0].length;
        int numPre = 0;

        int[] numMinLineArray = new int[numLine];
        for(int i = 0; i < numLine; i++ ){
            //同一行中最小
            int numLineMin = 0;
            for(int j = 0; j < numColumn; j++ ){
                if(j > 0){
                    //上一个数
                    numPre = matrix[i][j-1];
                }else{
                    numPre = matrix[i][j];
                }
                //当前数
                int numCur = matrix[i][j];
                if(numCur <= numPre){
                    numLineMin = numCur;
                }
            }
            numMinLineArray[i] = numLineMin;
        }
        int[] numMaxColumnArray = new int[numColumn];
        for(int i = 0; i < numColumn; i++ ){
            //同一列中最大
            int numColumnMax = 0;
            for(int j = 0; j < numLine; j++ ){
                if(j > 0){
                    //上一个数
                    numPre = matrix[i][j-1];
                }else{
                    numPre = matrix[i][j];
                }
                //当前数
                int numCur = matrix[i][j];
                if(numCur >= numPre){
                    numColumnMax = numCur;
                }
            }
            numMaxColumnArray[i] = numColumnMax;
        }
        List<Integer> result = new ArrayList<>(1);
        for(int i = 0 ; i < numMinLineArray.length;i++){
            for(int j = 0; j < numMaxColumnArray.length; j++ ){
                if(i == j){
                    result.add(i);
                }
            }
        }

        return result;
    }
}
