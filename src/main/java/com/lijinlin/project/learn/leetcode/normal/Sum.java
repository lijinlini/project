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
public class Sum {
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
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            leftPoint = i + 1;
            list = twoSum(i, leftPoint, rightPoint, -nums[i], nums);
            resultList.addAll(list);
        }
        return resultList;
    }

    private static List<List<Integer>> twoSum(int curPoint, int leftPoint, int rightPoint, int target, int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        while (leftPoint < rightPoint) {
            int sum = nums[leftPoint] + nums[rightPoint];
            if (sum == target) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[leftPoint]);
                list1.add(nums[curPoint]);
                list1.add(nums[rightPoint]);
                list.add(list1);
                while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]) {
                    rightPoint--;
                }
                rightPoint--;
                while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]) {
                    leftPoint++;
                }
                leftPoint++;
            }
            if (sum > target) {
                rightPoint--;
            }
            if (sum < target) {
                leftPoint++;
            }

        }
        return list;
    }

    /**
     * 18. 四数之和
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 
     * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //1先排序
        Arrays.sort(nums, 0, nums.length);
        List<List<Integer>> resultList = new ArrayList<>();
        //2外层一个i
        for (int i = 0; i < nums.length - 3; i++) {
            //如果当前值和当前值的下一个相等就进行continue
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //先判断如果四个最小值相加都大于目标值就结束
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long)nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //如果当前值和当前值的下一个相等就进行continue
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //判断最小值
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long)nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                //4双指针
                int leftPoint = j + 1;
                int rightPoint = nums.length - 1;
                while (leftPoint < rightPoint) {
                    //判断 四个数相加是 等于 大于 小于
                    long sum = (long) nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[leftPoint]);
                        list.add(nums[rightPoint]);
                        resultList.add(list);

                        while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]) {
                            leftPoint++;
                        }
                        leftPoint++;
                        while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]) {
                            rightPoint--;
                        }
                        rightPoint--;
                    }
                    if (leftPoint < rightPoint && nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint] > target) {
                        rightPoint--;
                    }
                    if (leftPoint < rightPoint && nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint] < target) {
                        leftPoint++;
                    }
                }

            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 2, 2, 2, 2};
        //int[] nums = {-2, -1, 0, 0, 1, 2};
        int[] nums = {0, 0, 0, 1000000000,1000000000,1000000000,1000000000};
        //int[] nums = {0, 0, 0, 100, 100, 100, 100};
        System.out.println(fourSum(nums, 1000000000));
    }

}
