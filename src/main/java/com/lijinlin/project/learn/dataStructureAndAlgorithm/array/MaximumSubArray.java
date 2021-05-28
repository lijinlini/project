package com.lijinlin.project.learn.dataStructureAndAlgorithm.array;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxMumSubarray(nums);
        System.out.println(res);
    }

    /**
     * 分治
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public static int maxMumSubarray(int[] nums) {
        int preMaxMum = 0, curMaxMum = nums[0];

        for (int i : nums) {
            preMaxMum = Math.max(i, preMaxMum + i);
            curMaxMum = Math.max(preMaxMum, curMaxMum);
            System.out.println("preMaxMum:" + preMaxMum + "   curMaxMum:" + curMaxMum + "     i:"+i);
        }
        return curMaxMum;
    }
}
