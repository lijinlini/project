package com.lijinlin.project.learn.dataStructureAndAlgorithm.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
       /* doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);*/
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);

        doubleLinkedList.list();

        HeroNode2 new4 = new HeroNode2(4, "林冲~", "豹子头!");
        doubleLinkedList.update(new4);
        doubleLinkedList.list();

        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }
}


//创建一个双向链表的类
class DoubleLinkedList {
    //初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍然能够过一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }

    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode;
        if (temp.next != null) {
            heroNode.pre = temp;
        }
    }

    //根据编号删除节点
    //对于双向链表，我们可以直接找到要删除的这个节点，找到后自我删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经找到链表最后了
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //删除下一个节点
            temp.pre.next = temp.next;
            //
            temp.next.pre = temp.pre;
        } else {
            //没有要删除的节点
            System.out.printf("没有要删除的节点%d,不存在", no);
        }

    }

    public void update(HeroNode2 newHeroNode) {
        //根据编号更新数据
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head.next;
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

//创建一个双向链表的类
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    //指向下个节点 默认为null
    public HeroNode2 next;
    //指向上一个节点 默认为null
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}