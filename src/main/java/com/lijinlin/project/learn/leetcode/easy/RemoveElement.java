package com.lijinlin.project.learn.leetcode.easy;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2,3};
        int val = 3;
        System.out.println(removeElementV2(nums,val));
    }
    /**
     * 双指针解决
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int slowPoint = 0;
        int length = nums.length;
        for (int fastPoint = 0; fastPoint < length; fastPoint++) {
            if (nums[fastPoint] == val) {
                if(slowPoint != fastPoint){
                    continue;
                }
            }else{
                nums[slowPoint] = nums[fastPoint];
                slowPoint++;
            }
        }
        return slowPoint;
    }

    /**
     * 优化双指针方法，从数组两头开始，如果左边的等于目标值则把最右边的值移动到左边位置处继续判断，每次出现相等都去移动，知道两个指针重合结束，返回重合的指针位置即可
     * 好处：比从同一层减少了拷贝次数，只有需要时才拷贝
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementV2(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int leftPoint = 0;
        int length = nums.length;
        int rightPoint = length - 1;
        if(leftPoint == rightPoint){
            if(nums[leftPoint] == val){
                return 0;
            }
        }

        while (leftPoint != rightPoint){
            if(nums[leftPoint] ==  val){
                nums[leftPoint] = nums[rightPoint];
                rightPoint--;
            }else{
                leftPoint++;
            }
        }
        if(nums[leftPoint] == val){
            leftPoint--;
        }
        return ++leftPoint;
    }

}
