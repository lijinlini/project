package com.lijinlin.project.learn.Thread.futrure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lijinlin
 * @date2021年07月29日 17:02
 */
public class MyCallable implements Callable {
    Integer finalI;

    public MyCallable(Integer finalI) {
        this.finalI = finalI;
    }

    @Override
    public Object call() throws Exception {
        long mills = new Double(Math.random() * 10000).longValue();
        System.out.println(finalI + "," + mills);
        Thread.sleep(mills);
        return finalI + "";
    }

}
