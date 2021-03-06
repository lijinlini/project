package com.lijinlin.project.learn;

import org.openjdk.jol.info.ClassLayout;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.channels.Selector;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));


    public static void main(String[] args) throws Exception {
        Integer monitorCount = 1;
        Integer purchaseNum = 2;
        System.out.println(monitorCount.compareTo(purchaseNum));


        int a = 4;
        int b = -3;
        int c = 4;
        int d = 0;
        int e = (0 - 1) / 2;
        System.out.println((a - 1) / 2);
        System.out.println((b - 1) / 2);
        System.out.println(a < c);
        System.out.println((d - 1) / 2);
        System.out.println((b - 1) / 3);
        System.out.println((0 - 1) / 2);
        System.out.println(e);
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


