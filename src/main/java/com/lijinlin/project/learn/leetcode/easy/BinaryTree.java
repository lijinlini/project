package com.lijinlin.project.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 二叉树中序遍历
     * 中序： 左-自己-右-返回上一级  左-自己-右-返回上一级 左-自己-右-返回上一级 。。。。。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = middleOrder(root,result);
        return result;
    }
    public List<Integer> middleOrder(TreeNode node,List<Integer> list){
        if(node == null){
            return list;
        }
        if(node.left != null){
            list = middleOrder(node.left,list);
        }
        list.add(node.val);
        if(node.right != null){
            list = middleOrder(node.right,list);
        }
        return list;
    }


}
