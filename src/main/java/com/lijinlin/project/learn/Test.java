package com.lijinlin.project.learn;

import org.openjdk.jol.info.ClassLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));


    public static void main(String[] args) throws Exception {
        System.out.println(DATE_FORMAT_THREAD_LOCAL.get().format(new Date()));

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sd.format(new Date()));

        /*TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;

        sortByLayer(treeNode1);*/

        
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


