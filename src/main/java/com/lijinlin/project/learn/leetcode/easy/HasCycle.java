package com.lijinlin.project.learn.leetcode.easy;

public class HasCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        boolean res = true;
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            if(fast == null || fast.next == null){
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
       // node2.next = node1;
        System.out.println(hasCycle(node1));
    }
}
