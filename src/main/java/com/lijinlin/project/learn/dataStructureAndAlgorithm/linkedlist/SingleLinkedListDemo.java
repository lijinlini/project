package com.lijinlin.project.learn.dataStructureAndAlgorithm.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero4);
        System.out.println("链表1~~");
        singleLinkedList1.list();

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero3);
        System.out.println("链表2~~");
        singleLinkedList2.list();

        System.out.println("合并两个链表~~");
        SingleLinkedList singleLinkedList3 = mergeSingleLinkedList(singleLinkedList1,singleLinkedList2);
        singleLinkedList3.list();
        /*System.out.println();
        System.out.println("反转链表~~");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("使用栈的方式逆序打印~~");
        stackReverseList(singleLinkedList.getHead());*/



        /*HeroNode hero22 = new HeroNode(2, "俊义", "玉麒麟~~");
        singleLinkedList.update(hero22);
        singleLinkedList.list();


        //删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);

        System.out.println("删除后的数据");
        singleLinkedList.list();

        System.out.println("有效的节点个数" + getLength(singleLinkedList.getHead()));

        //找倒数第k个节点
        System.out.println("找倒数第k个节点~~");
        int k = 3;
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),k);
        System.out.println("res:" + res);*/

    }
    /**
     * 合并两个有序的单链表，合并之后的单链表依然有序 从小到大排序
     */
    public static SingleLinkedList mergeSingleLinkedList(SingleLinkedList list1,SingleLinkedList list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        HeroNode headHeroNode1 = list1.getHead();
        HeroNode curNode = headHeroNode1.next;
        while (curNode != null){
            HeroNode addNode = curNode;
            curNode = curNode.next;
            list2.addByOrder(addNode);
        }

        return list2;
    }

    /**
     * 使用栈结构逆序打印数据
     */
    public static void stackReverseList(HeroNode headHerNode) {
        if (headHerNode.next == null) {
            System.out.println("没有数据");
            return;
        }
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode cur = headHerNode.next;
        while (cur != null) {
            heroNodeStack.add(cur);
            cur = cur.next;
        }
        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }

    /**
     * 单链表的反转（腾讯）
     * 1新建一个头节点
     * 2循环遍历之前单列表
     * 3便利出来一个数据把新的头节点指向这个数据，把这个数据的next指向之前头节点的下一个next
     * 4把之前头节点指向最后一个数据
     * 5返回
     */
    public static void reverseList(HeroNode headHeroNode) {
        if (headHeroNode.next == null || headHeroNode.next.next == null) {
            return;
        }
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode next = null;
        HeroNode cur = headHeroNode.next;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        headHeroNode.next = newHead.next;
    }

    /**
     * 新浪面试题
     * 查找单链表中的倒数第K个节点（新浪面试题）
     * 1输入要查找的头节点，和倒数第几个索引
     * 2获取该头节点下有多少个数据
     * 3用获取的数据个数-倒数的数量就是正数第几个
     * 4重新便利，取正数数量的节点返回
     *
     * @param head
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;//没有找到
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList 管理额我们的英雄
class SingleLinkedList {
    //初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑编号顺序时
    //1找到当前链表最后节点
    //2将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当推出while循环时，temp指向了链表的最后
        temp.next = heroNode;
    }

    //第二种方式在添加节点时，根据排名将英雄插入到指定位置
    //如果有这个排名，则添加失败，给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然能够过一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        //根据no判断是否已经存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("节点数据编号%d已经存在,不能加入了\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //根据编号删除节点
    public void delete(int no) {
        HeroNode temp = head;
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //没有要删除的节点
                System.out.println("链表为空");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //删除下一个节点
            temp.next = temp.next.next;
        } else {
            //没有要删除的节点
            System.out.printf("没有要删除的节点%d,不存在", no);
        }

    }

    public void update(HeroNode newHeroNode) {
        //根据编号更新数据
        HeroNode temp = head.next;
        //是否存在该节点
        Boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("链表为空");
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("节点数据编号%d不存在,不能更新了\n", newHeroNode.no);
        }
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能移动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//每个heroNode对象是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    //指向下个节点
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
