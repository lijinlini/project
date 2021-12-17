package com.lijinlin.project.learn.dataStructureAndAlgorithm.map.bitMap;

public class BigMapTest {
    private int[] bigArray;

    public BigMapTest(long size){
        bigArray = new int[(int)(size / 32 + 1)];
    }

    public void set1(int num){
        //确定数组 index 向右移5位相当于 除以32
        int arrayIndex = num >> 5;
        //确定bit index 两个操作中位都位1则为1否则为0
        int bitIndex = num & 31;
        //设置1 优先 按位左移 再 进行或运算
        bigArray[arrayIndex] |= 1 << bitIndex;
    }

    public void set0(int num){
        //确定数组 index
        int arrayIndex = num >> 5;
        int bitIndex = num & 31;
        //设置0
        bigArray[arrayIndex] &= ~(1 << bitIndex);
        System.out.println(get32BitBinString(bigArray[arrayIndex]));
    }
    private static String get32BitBinString(int number){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 32; i++){
            stringBuilder.append(number & 1);
            number = number >>>1;
        }
        return stringBuilder.reverse().toString();
    }
    public boolean isExist(int num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;
        //判断是否存在
        return (bigArray[arrayIndex] & ((1 << bitIndex))) != 0;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,35,22,56,334,245,2234,54};
        BigMapTest bigMapTest = new BigMapTest(2234 - 1);
        for(int i : arrays){
            bigMapTest.set1(i);
        }
        System.out.println(bigMapTest.isExist(3));
    }
}
