package com.lijinlin.project.learn.datastructureandalgorithm.binarysorttree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SortByLayer {

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);
        root3.left = root9;
        root3.right = root20;
        root9.left = root15;
        root9.right = root7;
        ArrayList<ArrayList<Integer>> list = levelOrder(root3);
        System.out.println("[");
        for(ArrayList<Integer> list1 : list){
            System.out.print("[");
            for(Integer value : list1){
                System.out.print(value+",");
            }
            System.out.println("],");
        }
        System.out.println("]");

    }

    /**
     * 给定一个root节点把root节点下的数据都添加同层一下一个指向，root的next为null
     * 求二叉树的层序遍历
     * 限定语言：Kotlin、Typescript、Python、C++、Groovy、Rust、Java、Go、Scala、Javascript、Ruby、Swift、Php、Python 3
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * <p>
     * 该二叉树层序遍历的结果是
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * For example:
     * Given binary tree{3,9,20,#,#,15,7},
     * <p>
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @author lijinlin
     * @date 2021/5/8 17:51
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //使用队列实现
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode curNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curNode);

        while (!queue.isEmpty()) {
            //获取队列大小
            int queueSize = queue.size();
            ArrayList<Integer> lineList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                //取出队列最早的数据
                curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                lineList.add(curNode.value);
            }
            res.add(lineList);
        }
        return res;
    }
    //有下一个节点的二叉树
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;


        public TreeNode(int value) {
            this.value = value;
        }
    }

     /* public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) return res;
            queue.add(root);
            while(!queue.isEmpty()){
                int cur = queue.size();
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                for(int i=0;i<cur;i++){
                    TreeNode t= queue.poll();
                    tmp.add(t.val);
                    if(t.left != null)
                        queue.add(t.left);
                    if(t.right != null)
                        queue.add(t.right);
                }
                res.add(tmp);
            }
            return res;
        }*/
}
