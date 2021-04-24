package com.lijinlin.project.learn.Thread;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public class AliQuestionAboutCF {
    /**
     * 有这样一个任务T:
     * T由N个子任务构成，每个子任务完成的时长不同，若其中有个子任务失败，所有任务结束，T任务失败
     * 请写程序模拟这个过程，要求速度尽量快。
     * 1通过CompletableFuture实现
     * 2手工实现
     */
    public static void main(String[] args) throws Exception {
        MyTask tas1 = new MyTask("task1", 3, true);
        MyTask tas2 = new MyTask("task2", 4, true);
        MyTask tas3 = new MyTask("task3", 1, false);

        CompletableFuture f1 = CompletableFuture.supplyAsync(() -> tas1.call()).thenAccept((result) -> callback(result));
        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> tas2.call()).thenAccept((result) -> callback(result));
        CompletableFuture f3 = CompletableFuture.supplyAsync(() -> tas3.call()).thenAccept((result) -> callback(result));

        System.in.read();
    }

    private static void callback(Boolean result) {
        if (false == result) {
            //处理结束流程
            //通知其他县城结束（回滚）
            //超时处理
            System.exit(0);
        }
    }

    private static class MyTask {
        private String name;
        private int timeInSeconds;
        private boolean ret;

        private Boolean call() {
            try {
                Thread.sleep(this.timeInSeconds * 1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.ret;
        }

        public MyTask(String name, int timeInSeconds, boolean ret) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.ret = ret;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTimeInSeconds() {
            return timeInSeconds;
        }

        public void setTimeInSeconds(int timeInSeconds) {
            this.timeInSeconds = timeInSeconds;
        }

        public boolean isRet() {
            return ret;
        }

        public void setRet(boolean ret) {
            this.ret = ret;
        }
    }
}
