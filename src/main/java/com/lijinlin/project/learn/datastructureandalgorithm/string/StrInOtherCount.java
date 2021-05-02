package com.lijinlin.project.learn.datastructureandalgorithm.string;

/**
 * @author lijinlin
 * @date2021年05月02日 14:32
 */
public class StrInOtherCount {

    public static void main(String[] args) {
        String str = "asf";
        String sub = "sf";
        //count(str, sub);
        String str1 = "afdsdse";
        String str2 = "aaaffffddddddsssssss";
        count2(str1,str2);
    }

    /**
     * 求一个字符串a在另一个字符串中出现次数
     * 比如 acdsdf 中 ds出现次数 是1 d的出现次数是2
     *
     * @param str
     * @param sub
     * @return int
     * @author lijinlin
     * @date 2021/5/2 14:34
     */
    public static int count(String str, String sub) {
        //1先看sub的长度
        int lengthSub = sub.length();
        int lengthStr = str.length();
        int count = 0;
        String curSub;
        //abcbd bc
        for (int i = 0; i < lengthStr - lengthSub + 1; i++) {
            curSub = str.substring(i, i + lengthSub);
            if (curSub.equals(sub)) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    /**
     * 有两个字符串，判断一个字符串中的字母在另一个字符串中出现的次数
     * 判断1中的字母在2里面存在的出现次数
     *
     * @param str1
     * @param str2
     * @return int
     * @author lijinlin
     * @date 2021/5/2 14:55
     */
    public static int count2(String str1, String str2) {
        //str1 = "afdsdse"
        //str2 = "aaaffffddddddsssssss";
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            count = 0;
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    count++;
                }
            }
            System.out.println(chars1[i] + "出现了" + count + "次");
        }

        return count;
    }
}
