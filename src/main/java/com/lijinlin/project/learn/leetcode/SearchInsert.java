package com.lijinlin.project.learn.leetcode;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 */
public class SearchInsert {
    /**
     * 二分法 是最直观的思路效率达标
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int right = nums.length;
        int left = 0;
        int middlePosition = (right + left) / 2;
        boolean notStopFlag = true;
        int result = 0;
        while(notStopFlag){
            if(target > nums[middlePosition] ){
                if(target <=  nums[middlePosition + 1]){
                    result = middlePosition + 1;
                    notStopFlag = false;
                }
                left = middlePosition;
                //right = right;
            }else{
                if(target >=  nums[middlePosition - 1]){
                    result = middlePosition - 1;
                    notStopFlag = false;
                }
                //left = left;
                right =  middlePosition;
            }
            middlePosition = (right + left) / 2;
        }
        return result;
    }
}
