package com.lijinlin.project.learn.leetcode.normal;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaViolence(a));
    }

    /**
     * 暴力解法(执行时间过长)
     * @param height
     * @return
     */
    public static int maxAreaViolence(int[] height) {
        int max = 0;
        for(int i = 0;i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                int leftLength = height[i];
                int rightLength = height[j];
                int tempMax = 0;
                if(leftLength > rightLength){
                    tempMax = rightLength * (j - i);
                }else{
                    tempMax = leftLength * (j - i);
                }
                if(tempMax > max){
                    max = tempMax;
                }
            }
        }
        return max;
    }
}
