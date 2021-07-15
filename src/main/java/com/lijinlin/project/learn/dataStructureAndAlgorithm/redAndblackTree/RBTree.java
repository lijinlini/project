package com.lijinlin.project.learn.dataStructureAndAlgorithm.redAndblackTree;

/**
 * @author lijinlin
 * @date2021年07月15日 18:07
 */
public class RBTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }
    //左旋的实现
    private void leftRotate(RBNode p){

    }
    //右旋的实现
    private void rightRotate(){

    }

    //定义节点类型
    static class RBNode<K extends Comparable<K>,V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode(RBNode parent, K key, V value) {
            this.parent = parent;
            this.key = key;
            this.value = value;
        }
    }
}
