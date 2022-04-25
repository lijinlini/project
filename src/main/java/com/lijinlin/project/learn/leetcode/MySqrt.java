package com.lijinlin.project.learn.leetcode;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 *
 * 
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *

 */
public class MySqrt {
    /**
     * 简单计算器方法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        // 将求平方根的运算转换为指数运算和对数运算
        int result = (int)Math.exp(0.5 * Math.log(x));

        return (long)(result + 1) * (result + 1) <= x ? result + 1 : result;
    }
}
