package com.lijinlin.project.learn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                if(queue.size() == 10){
                    try {
                        queue.notify();
                        queue.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产一个任务，当前队列长度" + queue.size());
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            super.run();
        }
        private void consumer(){
            while(true){
                if(queue.size() == 0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费一条任务，当前队列长度：" + queue.size());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }

}
