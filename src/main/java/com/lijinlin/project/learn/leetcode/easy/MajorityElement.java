package com.lijinlin.project.learn.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    /**
     * 169. 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 执行用时：
     * 13 ms
     * , 在所有 Java 提交中击败了
     * 21.64%
     * 的用户
     * 内存消耗：
     * 45.2 MB
     * , 在所有 Java 提交中击败了
     * 41.92%
     * 的用户
     * 通过测试用例：
     * 45 / 45
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer o = map.get(nums[i]);
                map.put(nums[i], o + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int num = nums.length / 2 + 1;
        Set<Integer> set = map.keySet();
        Object[] objects = set.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (map.get(objects[i]) >= num) {
                return (Integer) objects[i];
            }
        }
        return 0;
    }

    /**
     * 方法2 排序后再记录最大的连续下标数
     *
     * @param nums
     * @return
     */
    public static int majorityElementOrder(int[] nums) {
        Arrays.sort(nums);
        Integer num = nums.length / 2 + 1;
        Integer continuousValue = 1;
        Integer preValue = null;
        for (Integer i = 0; i < nums.length; i++) {
            if(preValue != null && nums[i] == preValue){
                continuousValue ++;
                if(continuousValue >= num){
                    return nums[i];
                }
            }else{
                continuousValue = 1;
                if(continuousValue >= num){
                    return nums[i];
                }
            }
            preValue = nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(majorityElementOrder(nums));
    }
}
