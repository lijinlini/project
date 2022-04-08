package com.lijinlin.project.learn.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-1};
        int result = maxSubArrayDynamicProgramming(nums);
        System.out.println(result);

    }

    /**
     * 贪心算法：当前值，之前和，当前和，最大和
     * 保留上一位累加的正数，如果是负数就看当前的数
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayGreedyAlgorithm(int[] nums) {
        //当前值
        int curNum = 0;
        //之前和
        int preSum = 0;
        //当前和
        int curSum = 0;
        //最大和
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curNum = nums[i];
            if (preSum < 0) {
                curSum = curNum;
            } else {
                curSum = preSum + curNum;
            }
            preSum = curSum;
            if (i == 0) {
                maxSum = curNum;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划方法计算
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayDynamicProgramming(int[] nums) {
        int curNum = 0;
        int preNum = 0;
        for (int i = 0; i < nums.length; i++) {
            curNum = nums[i];
            if(i > 0){
                preNum = nums[i - 1];
            }
            if(preNum > 0){
                curNum = preNum + curNum;
                nums[i] = curNum;
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
