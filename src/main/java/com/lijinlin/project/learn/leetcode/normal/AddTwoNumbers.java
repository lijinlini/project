package com.lijinlin.project.learn.leetcode.normal;

import java.awt.*;

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
        ListNode aNode1 = new ListNode(9);
        ListNode aNode2 = new ListNode(9);
        //ListNode aNode3 = new ListNode(3);
        aNode1.next = aNode2;
        //aNode2.next = aNode3;

        ListNode bNode1 = new ListNode(9);
        ListNode bNode2 = new ListNode(9);
        ListNode bNode3 = new ListNode(9);
        bNode1.next = bNode2;
        bNode2.next = bNode3;

        System.out.println(addTwoNumbers(aNode1,bNode1).val);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 使用do while循环 直到循环完两个链表之中返回
         */
        //当前相加的结果
        int curRes = 0;
        //是否进1
        Boolean isEnterOne = false;
        ListNode resultNode = new ListNode(0);
        ListNode preNode = new ListNode(-1);
        do{
            ListNode curNode = new ListNode(0);
            int l1Val = 0;
            int l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            //先算第一个相加的结果
            curRes = l1Val + l2Val;
            if(isEnterOne){
                curRes = curRes + 1;
            }
            isEnterOne = false;
            if(curRes > 9){
                curRes = curRes - 10;
                isEnterOne = true;
            }
            curNode.val = curRes;
            preNode.next = curNode;
            if(preNode.val == -1){
                resultNode.next = preNode;
            }
            preNode = curNode;

            if(l1 == null && l2 == null){
                if(isEnterOne){
                    curNode = new ListNode(1);
                    preNode.next = curNode;
                    isEnterOne = false;
                }
            }
            if(l1 == null && l2 != null){
                if(isEnterOne){
                    l2.val = l2.val + 1;
                    isEnterOne = false;
                }
            }
            if(l1 != null && l2 == null){
                if(isEnterOne){
                    l1.val = l1.val + 1;
                    isEnterOne = false;
                }
            }

        }while (isEnterOne || l1 != null || l2 != null);

        return resultNode.next.next;
    }
    static class ListNode {
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
