package com.lijinlin.project.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，   C，      D   和     M。
 *                      1   5  10  50   100      500       1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class RomanToInt {
    private static final Map<String,Integer> defaultMap = new HashMap<String,Integer>(8);
    static{
        defaultMap.put("I",1);
        defaultMap.put("V",5);
        defaultMap.put("X",10);
        defaultMap.put("L",50);
        defaultMap.put("C",100);
        defaultMap.put("D",500);
        defaultMap.put("M",1000);
    }
    public int romanToInt(String s) {
        return 0;
    }
}
