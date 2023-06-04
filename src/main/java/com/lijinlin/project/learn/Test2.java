package com.lijinlin.project.learn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static class Node{
        public int index;
        public Node next;
    }
    //第一题
    public static List<Node> find(Node[] nodeList){

        //定义一个map保存被找到的node也就是被其他node链指向的node
        Map findedMap = new HashMap<>();
        //按顺序循环nodeList,得到最上层的node
        for(Node node : nodeList){
            //拿到第一个节点之后开始遍历这个节点下的next指针，一直遍历到空
            Node cur = node;
            while(cur.next != null && cur.next != cur){
                //如果自己指向自己不行
                if(node.next == node){
                    break;
                }
                if(findedMap.containsKey(node)){
                    break;
                }
                findedMap.put(node.next,node.next.index);
                cur = cur.next;
            }
        }
        //再次循环nodeList,从map中取不到的就是不被其他node链指向的node链表
        Map notFindedMap = new HashMap<>();
        for(Node node : nodeList){
            if(findedMap.get(node) == null){
                notFindedMap.put(node,node.index);
            }
        }
        //把没有找到的转成list返回
        List<Node> list = new ArrayList<>(notFindedMap.entrySet());
        return list;
    }

    public static void main(String[] args) {
        Node[] array = new Node[5];
        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node0.index=0;
        node0.next=node1;
        array[0]= node0;

        node1.index=1;
        node1.next=node1;
        array[1]= node1;

        node2.index=(2);
        node2.next=node2;
        array[2]= node2;

        node3.index=(3);
        node3.next=node1;
        array[3]= node3;

        node4.index=4;
        node4.next=node3;
        array[4]= node4;

        //0,4
        List<Node> list = find(array);
       System.out.println(list.toString());
       System.out.println("jieshu");
    }


    public static class Node2{
        public int index;
        public Node next;
        public Node pre;
    }
}
