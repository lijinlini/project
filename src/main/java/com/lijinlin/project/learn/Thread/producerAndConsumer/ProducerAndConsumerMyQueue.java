package com.lijinlin.project.learn.Thread.producerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerMyQueue {

    public static void main(String[] args) {
        ProducerAndConsumerMyQueue producerAndConsumerMyQueue = new ProducerAndConsumerMyQueue();
        Producer producer = producerAndConsumerMyQueue.new Producer();
        Consumer consumer = producerAndConsumerMyQueue.new Consumer();
        producer.start();
        consumer.start();
    }

    private MyLinkedBlockingQueue queue = new MyLinkedBlockingQueue(10);

    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                int i = (int) queue.get();
                System.out.println("队列里面的数据：" + i);
            }
        }
    }


    //自己实现阻塞队列，生产者消费者，队列长度为10，当队列满了生产者不生产，队列为0消费者不消费
    class MyLinkedBlockingQueue<E> {
        //阻塞队列长度不可更改
        private final int capacity;
        //在这个list里面存数据
        private LinkedList<E> queue;
        //一共存了多少条数据
        private int count;
        //加锁实现阻塞
        private Lock lock = new ReentrantLock();
        //两种阻塞的情况，一个是满了，一个是空
        private Condition unFull = lock.newCondition();
        private Condition unEmpty = lock.newCondition();

        //有参构造
        public MyLinkedBlockingQueue(int capacity) {
            this.capacity = capacity;
            queue = new LinkedList<>();
        }

        //put方法
        public void put(E e) {
            //首先加锁，防止并发
            try {
                lock.lock();
                while (count == capacity) {
                    //阻塞队列满了，等着
                    unFull.await();
                }
                //如果消费掉了就继续生产
                queue.add(e);
                count++;
                unEmpty.signal();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //get方法
        public E get() {
            E e = null;
            try {
                lock.lock();
                while (count == 0) {
                    //说明没有办法消费进行阻塞
                    unEmpty.await();
                }
                //可以消费
                e = queue.pop();
                count--;
                unFull.signal();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
            return e;
        }
    }
}
