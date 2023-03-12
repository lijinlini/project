package com.lijinlin.project.learn.leetcode.easy;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = middleOrder(root, result);
        return result;
    }

    public List<Integer> middleOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (node.left != null) {
            list = middleOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            list = middleOrder(node.right, list);
        }
        return list;
    }

    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        //1先判断根是否为空
        if (p == null && q == null) {
            return result;
        }
        //从根节点开始判断是否相同，在判断左子树，再判断右子树递归判断
        result = isSameTreeIterator(p,q);

        return result;
    }

    public static boolean isSameTreeIterator(TreeNode p, TreeNode q){
        if(p == null && q == null){
            //节点相同 往下继续判断
            return true;
        }
        if(p != null && q == null){
            //节点不相同 则直接返回
            return false;
        }
        if(p == null && q != null){
            //节点不相同 则直接返回
            return false;
        }

        if(p.val == q.val){
            //节点相同 往下继续判断
           boolean leftRes = isSameTreeIterator(p.left,q.left);
           boolean rightRes = isSameTreeIterator(p.right,q.right);
           if(leftRes && rightRes){
               return true;
           }
           return false;
        }else{
            //节点不相同 则直接返回
            return false;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        result = isSymmetricDeep(root.left,root.right);
        return result;
    }
    /**
     * 101 给你一个二叉树的根节点 root ， 检查它是否轴对称。 深度优先
     * https://leetcode.cn/problems/symmetric-tree/
     * @param root1 root2
     * @return
     */
    public boolean isSymmetricDeep(TreeNode root1,TreeNode root2) {
        boolean result = true;
        if(root1 == null && root2 == null){
            return result;
        }

        if(root1 == null){
            result = false;
            return result;
        }
        if(root2 == null){
            result = false;
            return result;
        }
        if(root1.val != root2.val){
            result = false;
            return result;
        }

        boolean left = isSymmetricDeep(root1.left,root2.right);
        boolean right = isSymmetricDeep(root1.right,root2.left);
        return left && right;
    }
    /**
     * 101 给你一个二叉树的根节点 root ， 检查它是否轴对称。广度优先
     * https://leetcode.cn/problems/symmetric-tree/
     * @param root1 root2
     * @return
     */
    public boolean isSymmetricScope(TreeNode root1,TreeNode root2) {
        boolean result = true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()){
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            if(poll1 == null && poll2 == null){
                continue;
            }
            if(poll1 == null || poll2 == null){
                result = false;
                break;
            }
            if(poll1.val != poll2.val){
                result = false;
                break;
            }
            queue.add(poll1.left);
            queue.add(poll2.right);
            queue.add(poll1.right);
            queue.add(poll2.left);
        }
        return result;
    }


}
