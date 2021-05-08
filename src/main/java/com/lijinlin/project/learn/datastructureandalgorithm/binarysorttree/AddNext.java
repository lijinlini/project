package com.lijinlin.project.learn.datastructureandalgorithm.binarysorttree;


/**
 * @author lijinlin
 * @date2021年05月08日 17:37
 */
public class AddNext {
    /**
     * 给二叉树增加next节点，指向同一层的下一个节点
     * @author lijinlin
     * @date 2021/5/8 17:37
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

    }

    /**
     * 给定一个root节点把root节点下的数据都添加同层一下一个指向，root的next为null
     *
     * @param root
     * @author lijinlin
     * @date 2021/5/8 17:51
     */
    public void connectNext(TreeNode root) {
        //当前节点
        TreeNode curNode = root;
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
                /* todo 不懂*/
                if (lastChild != null) {
                    lastChild.next = curNode.left;
                }
                /*end*/
                curNode.left.next = curNode.right;
                lastChild = curNode.right;
            } else if (curNode.left != null) {
                /* todo 不懂*/
                if (lastChild != null) {
                    lastChild.next = curNode.left;
                }
                /*end*/
                lastChild = curNode.left;
            } else if (curNode.right != null) {
                /* todo 不懂*/
                if (lastChild != null) {
                    lastChild.next = curNode.right;
                }
                /*end*/
                lastChild = curNode.right;
            }
            //设置下一个节点，如果本层已经遍历完毕，移到下一层的第一个子节点
            if (curNode.next != null) {
                /* todo 不懂*/
                curNode = curNode.next;
            }else{
                /* todo 不懂*/
                curNode = firstChild;
                firstChild = null;
                lastChild = null;
            }


        }

    }

    //有下一个节点的二叉树
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode next;
        public TreeNode(int value) {
            this.value = value;
        }
    }
}
