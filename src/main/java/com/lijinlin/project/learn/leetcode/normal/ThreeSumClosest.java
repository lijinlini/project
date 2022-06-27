package com.lijinlin.project.learn.leetcode.normal;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-4,-1,1,2};
        System.out.println(threeSumClosest(nums, 1));
    }

    /**
     * 双指针 最接近得值应该是用两数相减取绝对值最小得
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int rightPoint = nums.length - 1;
        Integer minSum = null;
        Arrays.sort(nums);
        for (int curPoint = 0; curPoint < nums.length; curPoint++) {
            if(curPoint > 0 && nums[curPoint] == nums[curPoint - 1]){
                continue;
            }
            int tempSum = twoSumClosest(curPoint + 1,rightPoint,curPoint,target - nums[curPoint],nums);
            if(minSum == null){
                minSum = tempSum;
            }
            if(tempSum < minSum){
                minSum = tempSum;
            }

        }
        return minSum;
    }
    /**
     * 返回当前指针下三个数相加最接近答案得和
     */
    public static int twoSumClosest(int leftPoint,int rightPoint,int curPoint,int target,int[] nums){
        boolean isFirst = true;
        int curMin = 0;
        int absCurMin = 0;
        while(leftPoint < rightPoint){
            int tempMin = 0;
            int leftValue = nums[leftPoint];
            int rightValue = nums[rightPoint];
            //有可能为正有可能为负取绝对值比较
            tempMin = target - leftValue - rightValue;
            int absTempMin = Math.abs(tempMin);
            absCurMin = Math.abs(curMin);
            if(isFirst || absTempMin < absCurMin){
                curMin = tempMin;
                isFirst = false;
            }
            if(leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]){
                leftPoint ++;
            }
            leftPoint ++;
            if(leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]){
                rightPoint --;
            }
            rightPoint --;

        }
        return curMin;
    }
}
