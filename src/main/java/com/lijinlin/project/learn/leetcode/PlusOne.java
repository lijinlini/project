package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9};
        System.out.println(Arrays.stream(plusOne(digits)));
    }
    /**
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        List<Integer> list = new ArrayList<>(length + 1);
        int addNum = 0;
        if(digits[length - 1] + 1 > 9){
            addNum = 1;
            for (int i = length - 1; i >= 0; i--) {
                if(digits[i] + addNum > 9){
                    if(i != 0){
                        list.add(0);
                    }else{
                        list.add(0);
                        list.add(1);
                    }
                }else{
                    list.add(digits[i] + addNum);
                    addNum = 0;
                }
            }
        }
        if(list.size() != 0){
            int size = list.size();
            int[] result = new int[list.size()];
            int i = size - 1;
            for(Integer num : list){
                result[i] = num;
                i--;
            }
            return result;
        }
        digits[length - 1] = digits[length - 1] + 1;
        return digits;
    }
}
