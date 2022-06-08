package com.lijinlin.project.learn.leetcode.normal;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *输入：l1 = [2,4,3], l2 = [5,6,4]
 *输出：[7,0,8]
 *解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {



    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 使用do while循环 直到循环完两个链表之中返回
         */
        //当前相加的结果
        int curRes = 0;
        //是否进1
        Boolean isEnterOne = false;
        ListNode resultNode = new ListNode(0);
        do{
            //先算第一个相加的结果
            curRes = l1.val + l2.val;
            if(isEnterOne){
                curRes = curRes + 1;
            }

            isEnterOne = false;
            if(curRes > 9){
                isEnterOne = true;
            }

        }while (isEnterOne || l1 != null || l2 != null);

        return null;
    }
    class ListNode {
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

}
