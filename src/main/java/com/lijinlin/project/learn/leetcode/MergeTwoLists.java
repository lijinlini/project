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
        ListNode curNode = new ListNode(0);
        ListNode nextNode = null;
        ListNode resNode = curNode;
        while (list1 != null || list2 != null) {
            ListNode minNode = new ListNode();
            ListNode temp1 = list1;
            ListNode temp2 = list2;
            if(list1.val < list2.val){
                if(curNode.val < list1.val){
                    minNode = new ListNode(curNode.val,new ListNode(list1.val,list1.next));
                }else{
                    minNode = new ListNode(list1.val,new ListNode(curNode.val,curNode.next));
                }
            }else{
                if(curNode.val < list2.val){
                    minNode = curNode;
                }else{
                    minNode = list2;
                }
            }
            curNode.next = minNode;
            curNode = minNode;
            list1 = list1.next;
            list2 = list2.next;



            /*if (curNode.val == list2.val) {
                nextNode = list2;
                list2 = list2.next;
                list1 = list1.next;
                curNode.next = nextNode;
                curNode = curNode.next;
                continue;
            }
            if (list1.val < list2.val) {
                curNode.next = list1;
                list1 = list1.next;
                curNode = curNode.next;
                continue;
            }
            if (list1.val > list2.val) {
                curNode.next = list2;
                list2 = list2.next;
                curNode = curNode.next;
                continue;
            }*/
        }
        return resNode;
    }
}
