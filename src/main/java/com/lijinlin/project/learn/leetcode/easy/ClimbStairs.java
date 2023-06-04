package com.lijinlin.project.learn.leetcode.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairsDynamic(int n) {
        if(n == 1){
            return 1;
        }
        //1判断台阶数如果只有两个台阶直接返回即可因为只有两种方式
        if(n == 2){
            return 2;
        }
        //2 f(n) = f(n-1) + f(n-2) 因为要想走上第N阶台阶，每次只走1到2步的情况下，
        // 一定只有两种方式就是从第N-1的地方跨1个台阶或者从N-2的地方跨2个台阶，
        //所以可以得到f(n) = f(n-1) + f(n-2)，n-1的地方跨1个台阶实际的数量还是f(n-1),f(n-2)同理
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    /**
     * 迭代方法
     * @param n
     * @return
     */
    public static int climbStairsIteration(int n,int[] res) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(res[n] != 0){
            return res[n];
        }
        int re = climbStairsIteration(n - 1,res) + climbStairsIteration(n - 2,res);
        res[n] = re;
        return re;
    }
    public static int climbStairs(int n) {
        int[] res = new int[n+1];
        return climbStairsIteration(n,res);
    }
}
