package com.lijinlin.project.learn.dataStructureAndAlgorithm.binarysorttree;


/**
 * @author lijinlin
 * @date2021年05月08日 17:37
 */
public class AddNext {
    /**
     * 给二叉树增加next节点，指向同一层的下一个节点
     *
     * @author lijinlin
     * @date 2021/5/8 17:37
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        connectNext(root1);
        System.out.println(root1.value + "," + root2.value + "," + root2.next.value + "," + root4.value + "," + root4.next.value + "," + root4.next.next.value + "," + root4.next.next.next.value);
    }

    public static void connectNext(TreeNode curNode) {
        //当前节点下一行第一个节点
        TreeNode firstChild = null;
        //当前系欸但下一行最后一个节点
        TreeNode lastChild = null;
        //当前节点不是空的情况下才能进行下一行的节点处理
        while (curNode != null) {
            //记录第一个非空子节点
            if (firstChild == null) {
                firstChild = curNode.left == null ? curNode.right : curNode.left;
            }
            //设置子节点的next关系，3种情况 第一种左右都有，第二种左有，第三种右有
            if (curNode.left != null && curNode.right != null) {
                /* 当前节点的左右节点不为空，并且当前节点的下一行有最后一个节点，最后一个节点指向当前节点的左节点，左节点指向当前节点右节点，最后一个节点指向当前节点右节点*/
                if (lastChild != null) {
                    lastChild.next = curNode.left;
                }
                /*end*/
                curNode.left.next = curNode.right;
                lastChild = curNode.right;
            } else if (curNode.left != null) {
                /*当前节点右节点空，所以最后一个节点是当前节点左节点，最后一个节点指向当前节点左节点*/
                if (lastChild != null) {
                    lastChild.next = curNode.left;
                }
                /*end*/
                lastChild = curNode.left;
            } else if (curNode.right != null) {
                /*当前节点左节点为null，最后一个节点都是当前节点右节点，最后一个节点下一个指向当前节点右节点*/
                if (lastChild != null) {
                    lastChild.next = curNode.right;
                }
                /*end*/
                lastChild = curNode.right;
            }

            //设置下一个节点，如果本层已经遍历完毕，移到下一层的第一个子节点
            if (curNode.next != null) {
                /* 当不换行的时候，当前节点平行右移*/
                curNode = curNode.next;
            } else {
                /*当换行的时候，当前节点变成下一行第一个节点，清空下一行第一个和最后一个节点记录*/
                curNode = firstChild;
                firstChild = null;
                lastChild = null;
            }


        }

    }

    //有下一个节点的二叉树
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
