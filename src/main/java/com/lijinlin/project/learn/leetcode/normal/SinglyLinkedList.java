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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(removeNthFromEnd(node1,2).val);
    }
}
