package com.lijinlin.project.learn.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

public class LetterDeformation {
    /**
     * 6. N 字形变换
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String nConvert(String s, int numRows) {
        //1校验
        //字符串长度
        int sLength = s.length();
        if(numRows >= sLength || numRows == 1){
            return s;
        }
        //2定义方向是否向下
        boolean isDown = true;
        //当行数为0或者行数为 numRows-1时 isDown取反
        String[] rowArray = new String[numRows];
        int rowIndex = 0;
        for(int i = 0; i < sLength; i++){
            if(rowArray[rowIndex] == null){
                rowArray[rowIndex] = s.substring(i,i + 1);
            }else{
                rowArray[rowIndex] += s.substring(i,i + 1);
            }
            if(isDown){
                rowIndex ++;
            }else{
                rowIndex --;
            }
            if(rowIndex == 0 || rowIndex == numRows - 1){
                isDown = !isDown;
            }
        }
        StringBuffer res = new StringBuffer("");
        for(int i = 0;i < numRows; i++){
            res.append(rowArray[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(nConvert("AB", 2));
    }
}
