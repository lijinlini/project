package com.lijinlin.project.learn.leetcode.easy;

/**
 * 83.给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class DeleteDuplicatesListNode {
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

    public static ListNode deleteDuplicates(ListNode head) {
        boolean firstFlag = true;
        ListNode preNode = null;
        ListNode cur = head;
        while (cur != null) {
            if (firstFlag) {
                firstFlag = false;
                preNode = cur;
            } else {
                if (preNode.val == cur.val) {
                    preNode.next = cur.next;
                } else {
                    preNode = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 160.相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeDoublePointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != pointerB){
            if(pointerA == null){
                pointerA = headB;
            }else{
                pointerA = pointerA.next;
            }
            if(pointerB == null){
                pointerB = headA;
            }else{
                pointerB = pointerB.next;
            }

        }
        return pointerA;
    }

    public static void main(String[] args) {
       /* ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode resNode = deleteDuplicates(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }*/
        // 2 6 4
        // 1 5
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1,node4);
        System.out.println(getIntersectionNodeDoublePointer(node1,node5));
    }

}
