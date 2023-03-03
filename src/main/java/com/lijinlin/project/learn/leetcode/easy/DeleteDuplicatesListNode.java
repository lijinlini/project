package com.lijinlin.project.learn.leetcode.easy;

/**
 * 83.给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class DeleteDuplicatesListNode {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode resNode = deleteDuplicates(node1);
        while(resNode!=null){
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        boolean firstFlag = true;
        ListNode preNode = null;
        ListNode cur = head;
        while (cur != null){
            if(firstFlag){
                firstFlag = false;
                preNode = cur;
            }else{
                if(preNode.val == cur.val){
                    preNode.next = cur.next;
                }else{
                    preNode = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

}
