package com.lijinlin.project.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class Preorder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> resultList = null;
        if (resultList == null) {
            resultList = new ArrayList<>();
        }
        Integer cur = root.val;
        resultList.add(cur);
        if (root.children != null) {
            List<Integer> resultList1 = preorder(root.children.get(0));
            for (int i = 1; i < root.children.size(); i++) {
                resultList1.add(root.children.get(i).val);
            }
            resultList.addAll(resultList1);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> list1 = new ArrayList<>();
        Node root2 = new Node(3);
        Node root3 = new Node(2);
        Node root4 = new Node(4);
        list1.add(root2);
        list1.add(root3);
        list1.add(root4);
        root.children = list1;
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        List<Node> list2 = new ArrayList<>();
        list2.add(root5);
        list2.add(root6);
        root2.children = list2;
        System.out.println(preorder(root));
    }
}
