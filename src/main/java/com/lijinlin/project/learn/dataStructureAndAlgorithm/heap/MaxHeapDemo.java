package com.lijinlin.project.learn.dataStructureAndAlgorithm.heap;

import javafx.scene.Parent;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author lijinlin
 * @date2021年08月16日 16:06
 *          100
 *         /   \
 *       88     96
 *      /\      / \
 *    81  18  55  76
 *    Heap分max就是最上面节点最大，依次从大变小
 *    min就是最上面节点最小依次从小变大
 *    插入的时候会和父节点比较如果比父节点大就进行和父节点交换，不断比较直到满足上面
 */
public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeapDemo heapDemo = new MaxHeapDemo(7);

        System.out.println(heapDemo.hasParent(0));
    }

    //能存储多少节点
    private int capacity;
    //存储了多少个节点
    private int size = 0;
    private int[] array;
    public MaxHeapDemo(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    /**
     * 0 1 2 3 4 5 6
     *          0
     *         / \
     *        1   2
     *      / \   / \
     *     3   4 5   6
     *     注意下面方法都是取索引值而不是数组中具体的数值
     * @author lijinlin
     * @date 2021/8/16 16:15
     * @param parentIndex
     * @return null
     */
    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }
    //这里可能存在输入子节点是0返回的还是0的问题
    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index){
        /**
         * index是从0开始，size从1开始，所以是小于不是小于等于
         */
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
    //获取左孩子的值
    private int leftChild(int parentIndex){
        return array[getLeftChildIndex(parentIndex)];
    }
    //获取右孩子的值
    private int rightChild(int parentIndex){
        return array[getRightChildIndex(parentIndex)];
    }
    //获取父节点的值
    private int parent(int childIndex){
        return array[getParentIndex(childIndex)];
    }

    /**
     * 往堆中添加数据 时间复杂度是 O(logN) 这里log是以2为底，如果添加N=8,则只需要遍历4次
     * @author lijinlin
     * @date 2021/8/16 16:51
     * @param item
     * @return null
     */
    public void insert(int item){
        //如果当前大小等于容量
            //数组进行拷贝 并且新的数组容量大小是老的容量乘以2
            //容量大小 = 容量大小 乘以 2
        //数组【当前大小】 = 新添加的数据
        //当前大小 ++
        //进行交换节点
        if(size == capacity){
            array = Arrays.copyOf(array,capacity * 2);
            capacity = capacity * 2;
        }
        array[size] = item;
        size ++;
        heapIfyUp();
    }
    /**
     * 如果添加的数据比父节点大要和父节点进行交换，并且要循环
     * @author lijinlin
     * @date 2021/8/16 16:53
     * @return null
     */
    private void heapIfyUp(){
        //定义索引 = 存储的节点数 - 1；获取最新的索引位置
        int index = size - 1;
        //如果定义索引有父节点 并且 父节点的值 小于 当前索引的值
            //根据定义索引的父节点索引进行交换当前定义索引
            //定义索引 = 定义索引的父节点索引
        while(hasParent(index) && parent(index) < array[index]){
            //todo
            //swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    //时间复杂度O(logN)
    public  void  poll(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        int element = array[0];
        array[0] = array[size - 1];
        size -- ;
        //todo
        heapIfyDown();
    }
    private void heapIfyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int largerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)){
                largerChildIndex = getRightChildIndex(index);
            }
            if(array[index] < array[largerChildIndex]){
                //todo
                //swap(index,largerChildIndex);
            }else {
                break;
            }
            index = largerChildIndex;
        }
    }

    public int peek(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return array[0];
    }

}
