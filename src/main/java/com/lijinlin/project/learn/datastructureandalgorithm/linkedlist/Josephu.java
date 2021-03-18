package com.lijinlin.project.learn.datastructureandalgorithm.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();
        //出圈正确顺序 2 4 1 5 3
        circleSingleLinkedList.countBoy(1,2,25);
    }
}


class CircleSingleLinkedList {
    //先创建一个first节点
    private Boy first = null;


    //根据用户输入生成一个小孩出圈的顺序
    //小孩报数前，先让firt和helper移动k-1次
    //nums = 5有5个小孩
    //startNo=1，从第几个小孩开始报数
    //countNum=2，数两下
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入参数有误请重新输入");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                //说明helper指向了最后小孩系欸但
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让firt和helper移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if(helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("报数的小孩编号是%d\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
    }

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的只不正确");
            return;
        }
        Boy curBoy = null;
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有数据");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("当前是编号为%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            //curBoy后移
            curBoy = curBoy.getNext();
        }
    }
}

class Boy {
    private int no;
    //指向下个节点
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
