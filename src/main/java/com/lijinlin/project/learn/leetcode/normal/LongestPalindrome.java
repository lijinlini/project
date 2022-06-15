package com.lijinlin.project.learn.leetcode.normal;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeDynamic(s));
    }

    /**
     * 东态规划方法计算最大回文子串
     *
     * @param s
     * @return
     */
    private static String longestPalindromeDynamic(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        //回文串的最大长度
        int maxLength = 1;
        //回文串最大长度对应的起始位置
        int begin = 0;
        Boolean[][] rememberTable = new Boolean[len][len];
        //单个字母都是回文
        for(int i = 0;i<len;i++){
            rememberTable[i][i] = true;
        }
        //i 是右侧坐标 j是左侧坐标 循环按照先列再行的顺序便利
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(charArray[i] != charArray[j]){
                    //不相同一定不是回文串
                    rememberTable[i][j] = false;
                }else{
                    //相同情况下要判断 从i到j的数量，如果数量小于3则相当于两边相等中间只有一个，一定是回文串，如果i-1 = j+1则也是回文串
                    if(i - j < 3 || rememberTable[i - 1][j + 1]){
                        rememberTable[i][j] = true;
                    }else{
                        rememberTable[i][j] = false;
                    }
                }

                if(rememberTable[i][j] && i - j + 1 > maxLength){
                    maxLength = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /**
     * 暴力解法
     * 时间复杂度 O(n^3) n为字符串的长度
     * 空间复杂度 O(1),只用到常数个临时变量
     *
     * @param s
     * @return
     */
    public static String longestPalindromeViolence(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        //回文串的最大长度
        int maxLength = 1;
        //回文串最大长度对应的起始位置
        int begin = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && validPalindromic(charArray, i, j)) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /**
     * 验证子串 s[left..right]是否为回文串
     */
    private static boolean validPalindromic(char[] charArray, int left, int rigth) {
        while (left < rigth) {
            if (charArray[left] != charArray[rigth]) {
                return false;
            }
            left++;
            rigth--;
        }
        return true;
    }


}
