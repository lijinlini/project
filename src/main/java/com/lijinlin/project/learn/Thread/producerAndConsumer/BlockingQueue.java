package com.lijinlin.project.learn.Thread.producerAndConsumer;


import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {
    private static java.util.concurrent.BlockingQueue queue = new LinkedBlockingQueue();
    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put("a" + i);
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+ "-take - " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer" + i).start();
        }

    }
}
