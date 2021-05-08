package com.lijinlin.project.learn.Thread.pool;

import java.util.concurrent.*;

public class CallerRunsPolicyDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 15; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t办理业务");
            });
        }
    }
}
