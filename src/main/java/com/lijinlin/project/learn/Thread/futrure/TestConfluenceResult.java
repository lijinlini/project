package com.lijinlin.project.learn.Thread.futrure;

import com.lijinlin.project.server.aspect.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lijinlin
 * @date2021年07月29日 17:19
 */
public class TestConfluenceResult {
    private static final Logger logger = LoggerFactory.getLogger(TestConfluenceResult.class);
    private static ExecutorService executorService = new ThreadPoolExecutor(10,500,1, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

    public static void main(String args[]){
        List<Callable<String>> callableList = new ArrayList<>();
        long start = System.currentTimeMillis();
        logger.info("start----------------------" + start);
        for (int i = 0; i < 10; i++) {
            callableList.add(new MyCallable(i));
        }
        List<Future<String>> futureList;
        try{
            futureList = executorService.invokeAll(callableList);

            for (int i = 0; i < futureList.size(); i++) {
                logger.info("结果: " + futureList.get(i).get());
            }
            long end = System.currentTimeMillis();
            long timeLong = end - start;
            logger.info("时间**********************" + timeLong);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

    }
}
