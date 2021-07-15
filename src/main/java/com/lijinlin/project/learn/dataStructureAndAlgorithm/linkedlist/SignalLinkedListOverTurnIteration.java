package com.lijinlin.project.learn.dataStructureAndAlgorithm.linkedlist;

public class SignalLinkedListOverTurnIteration {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.next = treeNode2;
        treeNode2.next = treeNode3;
        treeNode3.next = treeNode4;
        treeNode4.next = treeNode5;
        TreeNode prev = recursion(treeNode1);
        System.out.println(prev);

    }

    //递归
    public static TreeNode recursion(TreeNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        TreeNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }
}

//每个TreeNode对象是一个节点
class TreeNode {
    public int no;

    //指向下个节点
    public TreeNode next;

    //构造器
    public TreeNode(int no) {
        this.no = no;
    }
    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }
}
