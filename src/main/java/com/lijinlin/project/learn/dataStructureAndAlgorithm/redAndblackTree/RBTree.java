package com.lijinlin.project.learn.dataStructureAndAlgorithm.redAndblackTree;

/**
 * @author lijinlin
 * @date2021年07月15日 18:07
 */
public class RBTree <K extends Comparable<K>,V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }
    /**
             左旋的实现
                  p                  pr
                 /\                 /\
               pl  pr   ==》       p  rr
                  /\              /\
                rl  rr          pl  rl
     */
    private void leftRotate(RBNode p){
        //1先判断p节点不为空
        if(p != null){
            RBNode pr = p.right;
            //1 pr-rl 变为 p-rl
            p.right = pr.left;
            if(pr.left != null){
                pr.left.parent = p;
            }

            //2 判断p是否有父节点
            pr.parent = p.parent;
            if(p.parent == null){
                root = pr;
            }else if(p.parent.left == p){
                p.parent.left = pr;
            }else {
                p.parent.right = pr;
            }

            //3 最后设置p为pr的左子节点
            pr.left = p;
            p.parent = pr;
        }
    }
    /**
     右旋的实现
              p                     pl
             /\                     /\
           pl  pr     ==>         ll  p
           /\                         /\
         ll  lr                     lr  pr
     */
    private void rightRotate(RBNode p){
        //1先判断p节点不为空
        if(p != null){
            RBNode pl = p.left;
            //1 pl-lr 变为 p-rl
            p.left = pl.right;
            if(pl.right != null){
                pl.right.parent = p;
            }
            //2 判断p是否有父节点
            pl.parent = p.parent;
            if(p.parent == null){
                root = pl;
            }else if(p.parent.left == p){
                p.parent.left = pl;
            }else{
                p.parent.right = pl;
            }
            //3 最后设置p为pl的右子节点
            pl.right = p;
            p.parent = pl;
        }
    }

    /**
     * 新增节点
     * @author lijinlin
     * @date 2021/8/3 9:51
     * @param key
     * @param value
     */
    public void put(K key,V value){

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
