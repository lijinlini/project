package com.lijinlin.project.learn;

import java.util.Stack;

public class SelftStack {
    static class Node<E> {
        Node<E> next = null;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }
    //value 是否是before，如果是就就设置为target
    boolean testAndSet(int value,int target,int before){
        //空实现
        return true;
    }
    static class ListNodeStack<E> {
        Node<E> top = null;

        boolean isEmpty() {
            return top == null;
        }

        public void push(E item) {
            Node<E> node = new Node<E>(item);
            node.next = top;
            top = node;
        }

        public E pop() {
            if (this.isEmpty()) return null;
            E data = top.data;
            top = top.next;
            return data;
        }

        public E peek() {
            if (this.isEmpty()) return null;
            return top.data;
        }
    }

    public static void main(String[] args) {

    }
}
