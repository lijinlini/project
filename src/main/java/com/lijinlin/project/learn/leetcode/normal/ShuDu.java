package com.lijinlin.project.learn.leetcode.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShuDu {
    public static boolean isValidSudoku(char[][] board) {
        boolean result = true;
        HashMap<Integer,Set<Character>> subBoxMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> column = new HashSet<>();
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                //校验列 没有重复的
                if (board[j][i] != '.' && !column.add(board[j][i])) {
                    result = false;
                    break;
                }
                //校验行 没有重复的
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    result = false;
                    break;
                }
                //校验9个3乘3的格子
                int k = i / 3 * 3 + j / 3;
                if (board[i][j] != '.') {
                    //k就是我这是子九宫格哪一个
                    if(subBoxMap.get(k) == null){
                        Set<Character> subBox = new HashSet<>();
                        subBox.add(board[i][j]);
                        subBoxMap.put(k,subBox);
                    }else{
                        if(!subBoxMap.get(k).add(board[i][j])){
                            result = false;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }
}
