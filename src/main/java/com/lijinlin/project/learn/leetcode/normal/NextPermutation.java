package com.lijinlin.project.learn.leetcode.normal;

import java.util.Collections;

public class NextPermutation {


    /**
     * 31. 下一个排列
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * <p>
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        //从低位到高位遍历，如果发现高位小于低位的就将左指针锁定
        int leftIndex = nums.length - 2;
        while(leftIndex >= 0 && nums[leftIndex] >= nums[leftIndex + 1]){
            leftIndex--;
        }
        if(leftIndex >= 0){
            //在从头遍历，尽量和小位的值交换才是最小交换
            int rightIndex = nums.length - 1;
            while(rightIndex > 0 && nums[leftIndex] >= nums[rightIndex]){
                rightIndex--;
            }
            swap(nums,leftIndex,rightIndex);
        }
        //如果遍历完都没有交换过，说明数组是4321这种最大值，那就直接翻转就行了
        reverse(nums,leftIndex+1);
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int leftIndex = start;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex){
            swap(nums,leftIndex,rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1}; //151   115
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
