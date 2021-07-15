package com.lijinlin.project.learn.dataStructureAndAlgorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijinlin
 * @date2021年05月02日 13:58
 */
public class FrequencySort {
    public static void main(String[] args) {
        String str = "cbabbaaaa";
        //输出结果应该是 aaaaabbbc
        frequencySort(str);
    }

    /**
     * 根据字符出现频率排序，给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * 排序高的放在前面
     *
     * @param str
     * @return
     * @author lijinlin
     * @date 2021/5/2 13:58
     */
    public static void frequencySort(String str) {
        //1把字符串转成数组
        char[] chars = str.toCharArray();
        //2使用hashMap统计数组中各个字符的出现顺序，怎么排序？
        HashMap<Character, Integer> charAndCountMap = new HashMap<>();
        for (char c : chars) {
            if (charAndCountMap.containsKey(c)) {
                charAndCountMap.put(c, charAndCountMap.get(c) + 1);
            } else {
                charAndCountMap.put(c, 1);
            }
        }
        //3把Map转成list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charAndCountMap.entrySet());
        //4通过comparator比较value值的大小，从大到小排序
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        StringBuilder builder = new StringBuilder();

        list.stream().forEach(en -> {
            //使用lambda表达式取key对应的value需要重复的次数
            for (int i = 0; i < en.getValue(); i++) {
                builder.append(en.getKey());
            }
        });
        String resStr = builder.toString();
        System.out.println(resStr);
    }
}
