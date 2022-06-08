package com.lijinlin.project.learn.leetcode.easy;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,8};
        int target = 9;
        System.out.println(searchInsert(nums,target));
    }
    /**
     * 二分法 是最直观的思路效率达标
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int right = nums.length - 1;
        int left = 0;
        int middlePosition = (right + left) / 2;
        boolean notStopFlag = true;
        if(target < nums[left]){
            return 0;
        }
        if(target > nums[right]){
            return right + 1;
        }
        int result = 0;
        while(notStopFlag){
            if(target > nums[middlePosition] ){
                left = middlePosition;
            }else if(target < nums[middlePosition]){
                right =  middlePosition;
            }else{
                //等于
                notStopFlag = false;
                result = middlePosition;
            }
            middlePosition = (right + left) / 2;
            if(right - left <= 1){
                notStopFlag = false;
                if(target == nums[left]){
                    result = left;
                }else{
                    result = right;
                }
            }
        }
        return result;
    }
}
