package com.lijinlin.project.learn.Thread.pool;

import java.util.concurrent.*;

public class DiscardPolicy {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 15; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "\t办理业务");
            });
        }
    }
}
