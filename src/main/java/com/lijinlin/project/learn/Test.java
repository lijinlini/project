package com.lijinlin.project.learn;

import com.alibaba.fastjson.JSON;
import com.lijinlin.project.learn.DesignPattern.bridging.Phone;
import com.lijinlin.project.learn.DesignPattern.bridging.XiaoMi;
import org.openjdk.jol.info.ClassLayout;

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
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime());
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


