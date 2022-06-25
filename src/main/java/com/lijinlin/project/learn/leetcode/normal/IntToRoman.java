package com.lijinlin.project.learn.leetcode.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(901));
    }
    public static String intToRoman(int num) {
        int[] numArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanSignalArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        boolean isEnd = false;
        int tempNum = num;
        //数组位置用来
        int i = 0;
        StringBuilder resultSignal = new StringBuilder("");
        while (!isEnd){
            String curSignal = "";
            if(tempNum >= numArray[i]){
                tempNum = tempNum - numArray[i];
                curSignal = romanSignalArray[i];
            }
            if(tempNum < numArray[i]){
                i++;
            }
            resultSignal.append(curSignal);
            if(tempNum == 0){
                isEnd = true;
            }
        }
        return resultSignal.toString();
    }
}
