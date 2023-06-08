package com.lijinlin.project.learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SelftStack {
    static class Node<Integer> {
        Node<Integer> next = null;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    //top 是否是pre，如果是就就设置为node
    static boolean testAndSet(int value, int target,int before) {
        return true;
    }

    static class ListNodeStack<Integer> {
        Node<Integer> top = null;
        volatile Object lock = null;


        boolean isEmpty() {
            return top == null;
        }

        public void pushByCas(Integer item) {
            Node<Integer> node = new Node<Integer>(item);
            int pre = (int)top.data;
            testAndSet((int)top.data,(int)item,pre);
        }
        public void pushByLock(Integer item) {
            Node<Integer> node = new Node<Integer>(item);
            Node<Integer> pre = top;
            synchronized(this){
                node.next = top;
                top = node;
            }
        }

        public Integer pop() {
            if (this.isEmpty()) return null;
            Integer data = top.data;
            top = top.next;
            return data;
        }

        public Integer peek() {
            if (this.isEmpty()) return null;
            return top.data;
        }
    }

    static class Runnable01 implements Runnable {
        private CountDownLatch latch;
        private ListNodeStack stack;
        private int i;
        private int j;

        public Runnable01(CountDownLatch latch, ListNodeStack stack, int i, int j) {
            this.latch = latch;
            this.stack = stack;
            this.i = i;
            this.j = j;
        }

        @Override
        public void run() {
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            for (int begin = i; begin < j; begin++) {
                stack.pushByLock(begin);
            }
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ListNodeStack stack = new ListNodeStack();
        ThreadPoolExecutor exs = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Runnable01 runnable01 = new Runnable01(countDownLatch, stack,0,10);
        Runnable01 runnable02 = new Runnable01(countDownLatch, stack,10,20);
        exs.execute(runnable01);
        exs.execute(runnable02);
        System.out.println("即将等待");
        countDownLatch.await();
        System.out.println("等待结束");
        int i = 0;
        while (true) {
            if (stack.peek() != null) {
                i++;
                System.out.println(stack.pop());

            } else {
                break;
            }
        }
        System.out.println(i);
    }
}
