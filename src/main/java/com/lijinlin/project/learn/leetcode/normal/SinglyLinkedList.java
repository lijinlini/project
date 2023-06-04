package com.lijinlin.project.learn.leetcode.normal;

public class SinglyLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 方法一使用快慢指针，快慢指针的快慢差距就是n
     * 空间复杂度O（1）时间复杂度O(n)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //相当于哑节点
        ListNode headHead = new ListNode(0);
        headHead.next = head;
        ListNode slowPointer = headHead;
        ListNode fastPointer = headHead;
        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        //此时等于空了，需要删除slowPointer的下一个节点
        if(slowPointer.next != null){
            slowPointer.next = slowPointer.next.next;
        }else{
            headHead = null;
        }

        return headHead.next;
    }

    /**
     * 24. 两两交换链表中的节点
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head != null && head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null && cur.next != null){
            //进行交换
            ListNode curNext = cur.next;
            ListNode tempNextNext = null;
            if(curNext.next != null){
                tempNextNext = curNext.next;
            }
            cur.next = tempNextNext;
            curNext.next = cur;
            if(pre != null){
                pre.next = curNext;
            }
            if(newHead == null){
                newHead = curNext;
            }
            //每次跳過一個
            pre = cur;
            cur = tempNextNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        /*ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(removeNthFromEnd(node1,2).val);*/


        ListNode node1 = new ListNode(1);
      /*  ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);*/
      /*  node1.next = node2;
        node2.next = node3;
        node3.next = node4;*/
        ListNode newHead = swapPairs(node1);
        System.out.println(newHead);
    }
}
