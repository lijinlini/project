package com.lijinlin.project.learn;

public class QuickSort {
    /*public static int[] quickSort(int[] arr,int begin, int end){//如果区间不只一个数
        if(begin < end) {
            int temp = arr[begin]; //将区间的第一个数作为基准数
            int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
            int j = end; //从右到左进行查找时的“指针”，指示当前右位置
            //不重复遍历
            while(i < j)
            {
                //当右边的数大于基准数时，略过，继续向左查找
                //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
                while(i<j && arr[j] > temp)
                    j--;
                //将右边小于等于基准元素的数填入右边相应位置
                arr[i] = arr[j];
                //当左边的数小于等于基准数时，略过，继续向右查找
                //(重复的基准元素集合到左区间)
                //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
                while(i<j && arr[i] <= temp)
                    i++;
                //将左边大于基准元素的数填入左边相应位置
                arr[j] = arr[i];
            }
            //将基准元素填入相应位置
            arr[i] = temp;
            //此时的i即为基准元素的位置
            //对基准元素的左边子区间进行相似的快速排序
            quickSort(arr,begin,i-1);
            //对基准元素的右边子区间进行相似的快速排序
            quickSort(arr,i+1,end);
        }
        //如果区间只有一个数，则返回
        return arr;
    }*/
    public static int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = nums[left];

            while (left < right) {

                while (left < right && nums[right] >= pivot) {

                    right--;

                }
                nums[left] = nums[right];

                while (left < right && nums[left] <= pivot) {

                    left++;
                }
                nums[right] = nums[left];

            }

            nums[left] = pivot;
            quickSort(nums, left, left - 1);
            quickSort(nums, left + 1, right);
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] quickNums = {23, 46, 0, 8, 11, 18};
        int[] quickArray = quickSort(quickNums, 0, quickNums.length - 1);
        for (int i : quickArray) {
            System.out.print(i + ",");
        }

    }
}
