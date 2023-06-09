package com.lijinlin.project.learn.leetcode.normal;

public class SearchArray {
    /**
     * 33. 搜索旋转排序数组
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        //先校验
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int result = -1;
        //思路还是二叉树搜索，只不过不在用中点判断，改成用数组二分后两端的值判断是否有序
        int length = nums.length;
        int leftIndex = 0;
        int rightIndex = length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (target == nums[middleIndex]) {
                return middleIndex;
            }
            if (nums[middleIndex] >= nums[0]) {
                //左边有序 并且target在左边有序的范围内
                if (target >= nums[0] && target < nums[middleIndex]) {
                    rightIndex = middleIndex - 1;
                } else {
                    leftIndex = middleIndex + 1;
                }
            } else {
                //右边有序 并且target在右边有序的范围内
                if (target > nums[middleIndex] && target <= nums[length - 1]) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }
        return result;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * 0123 4 56789
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }
        if(nums.length == 1){
            if(target == nums[0]){
                result[0] = 0;
                result[1] = 0;
                return result;
            }
        }
        int middleIndex = (nums.length - 1) / 2;
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        while (leftIndex <= rightIndex) {
            middleIndex = (rightIndex + leftIndex) / 2;
            if (target == nums[middleIndex]) {
                int leftResult = middleIndex;
                while(leftResult > 0 && target == nums[leftResult - 1]){
                    leftResult --;
                }
                int rightResult = middleIndex;
                while(rightResult < rightIndex && target == nums[rightResult + 1]){
                    rightResult ++;
                }
                result[0] = leftResult;
                result[1] = rightResult;
                return result;
            }
            if (nums[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            }
            if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*int[] a = {4, 5, 6, 7, 0, 1, 2}; //
        System.out.println(search(a, 0));*/

        int[] a = {1,2, 3}; //
        System.out.println(searchRange(a, 2));
    }
}
