package com.lijinlin.project.learn.leetcode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list14 = new ListNode(4);
        list11.next = list12;
        list12.next = list14;

        ListNode list21 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        ListNode list24 = new ListNode(4);
        list21.next = list22;
        list22.next = list24;

        ListNode res = mergeTwoLists(list11, list21);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

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
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //新链表的第一个节点firstResultNode
        ListNode firstResultNode = new ListNode(-1);
        ListNode newTailNode = firstResultNode;
        firstResultNode.next = newTailNode;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                newTailNode.next = list1;
                list1 = list1.next;
            }else{
                newTailNode.next = list2;
                list2 = list2.next;
            }
            newTailNode = newTailNode.next;
        }
        newTailNode.next = list1 == null ? list2 : list1;
        return firstResultNode.next;
    }
}
