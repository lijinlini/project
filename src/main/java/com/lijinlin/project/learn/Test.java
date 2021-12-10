package com.lijinlin.project.learn;

import com.alibaba.fastjson.JSON;
import com.lijinlin.project.learn.DesignPattern.bridging.Phone;
import com.lijinlin.project.learn.DesignPattern.bridging.XiaoMi;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.channels.Selector;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));


    public static void main(String[] args) throws Exception {
        Map<Long, List<Double>> map = new HashMap<Long, List<Double>>();
        List<Double> list = new ArrayList<>();
        map.put(1L, list);

        List<Double> a = map.get(6L);
        if(CollectionUtils.isEmpty(a)){
            System.out.println("asdfasd");
        }
       /* Long a = 1L;
        Long b = 2L;
        System.out.println(Long.compare(b,a));*/
    }

    public <K, V extends Number> Map<Long, V> sortMap(Map<Long, V> map) {
        class MyMap<M, N> {
            private M key;
            private N value;
            private M getKey() {
                return key;
            }
            private void setKey(M key) {
                this.key = key;
            }
            private N getValue() {
                return value;
            }
            private void setValue(N value) {
                this.value = value;
            }
        }

        List<MyMap<Long, V>> list = new ArrayList<MyMap<Long, V>>();
        for (Iterator<Long> i = map.keySet().iterator(); i.hasNext(); ) {
            MyMap<Long, V> my = new MyMap<Long, V>();
            Long key = i.next();
            my.setKey(key);
            my.setValue(map.get(key));
            list.add(my);
        }

        Collections.sort(list, new Comparator<MyMap<Long, V>>() {
            public int compare(MyMap<Long, V> o1, MyMap<Long, V> o2) {
                if(o1.getValue() == o2.getValue()) {
                    return Long.compare(o1.getKey(),o2.getKey());
                }else{
                    return new Double(o2.getValue().doubleValue()).compareTo(new Double(o1.getValue().doubleValue()));
                }
            }
        });

        Map<Long, V> sortMap = new LinkedHashMap<Long, V>();
        for(int i = 0, k = list.size(); i < k; i++) {
            MyMap<Long, V> my = list.get(i);
            sortMap.put(my.getKey(), my.getValue());
        }
        return sortMap;
    }

    //二叉树层序遍历
    public static void sortByLayer(TreeNode head) {
        if (head == null) {
            return;
        }
        //定义一个队列每次把节点放入队列，先进先出遍历
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }

            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            System.out.println(queue.poll().i);
        }
    }

    static class TreeNode {
        public int i;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int i) {
            this.i = i;
        }
    }
}


