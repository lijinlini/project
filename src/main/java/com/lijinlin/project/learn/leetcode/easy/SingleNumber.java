package com.lijinlin.project.learn.leetcode.easy;

public class SingleNumber {
    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     * <p>
     * 输入：nums = [2,2,1]
     * 输出：1。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     * 输入：nums = [1]
     * 输出：1
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberSort(nums));
    }
    public static int singleNumberSort(int[] nums) {
        singleNumberBySort(nums,0,nums.length - 1);
        int result = 0;
        for (int i = 0; i < nums.length; i = i+2) {
            if(i + 1 >= nums.length){
                result = nums[i];
                break;
            }
           if(nums[i] != nums[i+1]){
               if(nums[i + 1] == nums[i + 2]){
                   result = nums[i];
                   break;
               }
           }
        }
        return result;
    }

    public static void singleNumberBySort(int[] nums, int l, int r) {
       if(l >= r){
           return ;
       }
       int left = l;
       int right = r;
       int pivot = nums[left];
       while(left < right){
           while(left < right && nums[right] >= pivot){
               right --;
           }
           if(left < right){
               nums[left] = nums[right];
           }
           while(left < right && nums[left] <= pivot){
               left ++;
           }
           if(left < right){
               nums[right] = nums[left];
           }
           if(left >= right){
               nums[left] = pivot;
           }
       }
        singleNumberBySort(nums,l,right - 1);
        singleNumberBySort(nums,right + 1,r);
    }
}
