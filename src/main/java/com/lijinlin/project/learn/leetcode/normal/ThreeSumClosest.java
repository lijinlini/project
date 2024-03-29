package com.lijinlin.project.learn.leetcode.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // 1,4,6
        int[] nums = {1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(nums, 82));
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
        int minSum = 0;
        boolean isFirst = true;
        Arrays.sort(nums);
        for (int curPoint = 0; curPoint < nums.length; curPoint++) {
            if(curPoint > 0 && nums[curPoint] == nums[curPoint - 1]){
                continue;
            }
            Map<String,Integer> resultMap = twoSumClosestV2(curPoint + 1,rightPoint,curPoint,target - nums[curPoint],nums);
            if(resultMap.get("have") == 0){
                continue;
            }
            int tempSum =  resultMap.get("minSum");
            if(isFirst || Math.abs(tempSum - target) <= Math.abs(minSum - target)){
                minSum = tempSum;
                isFirst = false;
            }

        }
        return minSum;
    }
    /**
     * 优化v2版本
     * @param leftPoint
     * @param rightPoint
     * @param curPoint
     * @param target
     * @param nums
     * @return
     */
    public static Map<String,Integer> twoSumClosestV2(int leftPoint, int rightPoint, int curPoint, int target, int[] nums){
        boolean isFirst = true;
        int absCurMin = 0;
        int curValue = nums[curPoint];
        int minSum = 0;
        Map<String,Integer> result = new HashMap<>();
        result.put("have",0);
        while(leftPoint < rightPoint){
            int leftValue = nums[leftPoint];
            int rightValue = nums[rightPoint];
            int LRSum = leftValue + rightValue;
            //当前的差值的绝对值，该值越小越接近，为0 直接返回
            int curABSDValue = Math.abs(LRSum - target);
            if(curABSDValue == 0){
                minSum = curValue + nums[leftPoint] + nums[rightPoint];
                result.put("minSum",minSum);
                result.put("have",1);
                return result;
            }
            if(isFirst || curABSDValue < absCurMin){
                absCurMin = curABSDValue;
                minSum = curValue + nums[leftPoint] + nums[rightPoint];
                result.put("minSum",minSum);
                result.put("have",1);
            }

            while(leftPoint < rightPoint && target < LRSum){
                LRSum = nums[leftPoint] + nums[rightPoint];
                minSum = curValue + nums[leftPoint] + nums[rightPoint];
                result.put("minSum",minSum);
                result.put("have",1);
                rightPoint--;
            }
            while(leftPoint < rightPoint && target> LRSum){
                LRSum =  nums[leftPoint] + nums[rightPoint];
                minSum = curValue + nums[leftPoint] + nums[rightPoint];
                result.put("minSum",minSum);
                result.put("have",1);
                leftPoint++;
            }
            if(target < LRSum){
                rightPoint--;
            }else {
                leftPoint++;
            }
            isFirst = false;
        }
        return result;
    }
    /**
     * 返回当前指针下三个数相加最接近答案得和
     */
    public static Map<String,Integer> twoSumClosest(int leftPoint, int rightPoint, int curPoint, int target, int[] nums){

        boolean isFirst = true;
        int curMin = 0;
        int absCurMin = 0;
        int curValue = nums[curPoint];
        int minSum = 0;
        Map<String,Integer> result = new HashMap<>();
        result.put("have",0);
        while(leftPoint < rightPoint){
            int tempMin = 0;
            int leftValue = nums[leftPoint];
            int rightValue = nums[rightPoint];
            //有可能为正有可能为负取绝对值比较
            tempMin = target - leftValue - rightValue;
            int absTempMin = Math.abs(tempMin);
            absCurMin = Math.abs(curMin);
            if(tempMin == 0){
                if(isFirst || absTempMin < absCurMin){
                    minSum = curValue + nums[leftPoint] + nums[rightPoint];
                    result.put("minSum",minSum);
                    result.put("have",1);
                    return result;
                }
            }
            if(isFirst || absTempMin < absCurMin){
                curMin = tempMin;
                minSum = curValue + nums[leftPoint] + nums[rightPoint];
                result.put("minSum",minSum);
                result.put("have",1);
            }
            if(tempMin > 0){
                leftPoint ++;
            }
            if(tempMin < 0){
                rightPoint --;

            }
            isFirst = false;

        }
        return result;
    }


}
