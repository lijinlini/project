package com.lijinlin.project.learn.leetcode.normal;

public class DivideTwoNumber {
    /**
     * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
     * <p>
     * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的 商 。
     * <p>
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
     * <p>
     * 1:
     * <p>
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        int result = 0;
        //正数
        Boolean dividendFlag = true;
        if (dividend < 0) {
            dividendFlag = false;
        }
        long dividend1 = dividend;
        long positiveDividend = Math.abs(dividend1);

        Boolean divisorFlag = true;
        if (divisor < 0) {
            divisorFlag = false;
        }
        long divisor1 = divisor;
        long positiveDivisor = Math.abs(divisor1);

        long tempRes = 0;
        //被除数 大于 除数
        while (positiveDividend >= positiveDivisor) {
            //至少被除数中有1个  8 / 2
            long i = 1;
            //除数
            long tmp = positiveDivisor;
            while(positiveDividend >= tmp){
                tempRes += i;
                positiveDividend -= tmp;
                //除数变大两倍，结果也应该变大两倍，i就是结果
                tmp = tmp << 1;
                i = i << 1;

            }
        }
        if ((dividendFlag && divisorFlag) || (!dividendFlag && !divisorFlag)) {
            //都是正数
            if (tempRes > Math.pow(2, 31) - 1) {
                tempRes = (int) Math.pow(2, 31);
            }
        } else {
            //有一个是负数
            if (tempRes <= -Math.pow(2, 31)) {
                tempRes = -(int) Math.pow(2, 31);
            } else {
                tempRes = -tempRes;
            }
        }
        result = (int)tempRes;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(8,2));
    }
}
