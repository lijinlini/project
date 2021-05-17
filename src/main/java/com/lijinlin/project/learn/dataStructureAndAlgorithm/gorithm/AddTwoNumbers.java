package com.lijinlin.project.learn.dataStructureAndAlgorithm.gorithm;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(2);
        a3.next = a2;
        a2.next = a1;
        // 243 + 564 = 807
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(5);
        b3.next = b2;
        b2.next = b1;
        //返回结果 7->0->8 可以假设两个链表长度相同，并且最大的位数不为0
        addTwoNumbers(a1,b1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        ListNode newNode = null;
        ListNode preNode = null;
        int sum;
        while(tempNode1 != null && tempNode2 != null){
            sum = (tempNode1.val + tempNode2.val) % 10;
            newNode.val = sum;
            newNode.next = preNode;
            preNode = newNode;

            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;
        }
        return newNode;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
