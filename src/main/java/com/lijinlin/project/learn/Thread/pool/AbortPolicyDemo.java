package com.lijinlin.project.learn.Thread.pool;

import java.util.concurrent.*;

public class AbortPolicyDemo {
    public static void main(String[] args) {
        Object o = new Object();
        try{
            //直接抛出异常阻止系统正常运行
            ExecutorService threadPool = new ThreadPoolExecutor(2, 6, 1,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            for (int i = 0; i < 12; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
