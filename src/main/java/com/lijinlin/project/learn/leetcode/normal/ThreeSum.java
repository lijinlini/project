package com.lijinlin.project.learn.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         * 先对nums排序从小到大
         */
        Arrays.sort(nums, 0, nums.length);
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        List<List<Integer>> resultList = new ArrayList<>(64);
        for (int i = 0; i < nums.length - 1; i++) {
            List<List<Integer>> list = new ArrayList<>();
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            leftPoint = i + 1;
            list = twoSum(i,leftPoint,rightPoint,-nums[i],nums);
            resultList.addAll(list);
        }
        return resultList;
    }

    private static List<List<Integer>> twoSum(int curPoint,int leftPoint,int rightPoint,int target,int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        while(leftPoint < rightPoint){
            int sum = nums[leftPoint] + nums[rightPoint];
            if(sum == target){
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[leftPoint]);
                list1.add(nums[curPoint]);
                list1.add(nums[rightPoint]);
                list.add(list1);
                while(leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]){
                    rightPoint --;
                }
                rightPoint --;
                while(leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]){
                    leftPoint ++;
                }
                leftPoint ++;
            }
            if(sum > target){
                rightPoint--;
            }
            if(sum < target){
                leftPoint ++;
            }

        }
        return list;
    }
}
