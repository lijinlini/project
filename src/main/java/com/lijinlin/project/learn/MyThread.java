package com.lijinlin.project.learn;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class MyThread {
    public static void main(String[] args) {
        //用于获取到本java进程，进而获取总线程数
        /*RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeBean.getName();
        System.out.println("JVM Name = " + jvmName);
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("JVM PID = " + pid);
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        int n = 30000;
        for (int i = 0; i < n; i++) {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,1000, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            for(int j=0;j<10;j++){
                executor.execute(()->{
                    System.out.println("当前线程总数为："+bean.getThreadCount());
                });
            }
        }
        try{
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("线程总数为 = " + bean.getThreadCount());*/
        List<Integer> list = new ArrayList<>();
        ExecutorService taskPool = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 5; i++) {
            taskPool.execute(
                new Thread(() -> {
                    try {
                        Thread.sleep(10000);
                        int i1 = 1;
                        list.add(i1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        countDownLatch.countDown();
                    }
                })
            );
            System.out.println(i);
        }
        try{
            System.out.println(countDownLatch);
            countDownLatch.await(30,TimeUnit.SECONDS);
            taskPool.shutdown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
