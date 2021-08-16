package com.lijinlin.project.learn.dataStructureAndAlgorithm.queue;

/**
 * @author lijinlin
 * @date2021年08月16日 10:28
 */
public class PriorityQueueDemo {
    Node head = null;

    static class Node{
        int value;
        int priority;
        Node next;
        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    /**
     * O(n)时间复杂度，速度太慢
     * @author lijinlin
     * @date 2021/8/16 15:53
     * @param value
     * @param priority
     */
    public void push(int value,int priority){
        //1判断头节点是否为空，如果为空就新建头节点将当前值放入后返回
        if(head == null){
            head = new Node(value,priority);
            return;
        }
        //2头节点当当前节点，用入参创建一个新节点
        Node cur = head;
        Node newNode = new Node(value,priority);
        //3如果头节点优先级 小于 新添加节点优先级
            //则新节点下一个 是 头节点
            //新节点变成头节点
        //否则
            //循环当前节点下一个不等于null并且当前节点下一个节点优先级大于新添加的优先级
                //则当前节点 = 当前节点的下一个；
            //新节点的下一个节点=当前节点的下一个
            //当前节点的下一个 = 新加入节点
        if(head.priority < newNode.priority){
            newNode.next = head;
            head = newNode;
        }else{
            while(cur.next != null && cur.next.priority > newNode.priority){
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    /**
     * Heap堆进行添加 insert优化插入速度
     *         100
     *        /   \
     *      88     96
     *     /\      / \
     *   81  18  55  76
     *   Heap分max就是最上面节点最大，依次从大变小
     *   min就是最上面节点最小依次从小变大
     *   插入的时候会和父节点比较如果比父节点大就进行和父节点交换，不断比较直到满足上面
     * @author lijinlin
     * @date 2021/8/16 15:54
     * @return com.lijinlin.project.learn.dataStructureAndAlgorithm.queue.PriorityQueueDemo.Node
     */


    public Node peek(){
        return head;
    }

    public Node pop(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
