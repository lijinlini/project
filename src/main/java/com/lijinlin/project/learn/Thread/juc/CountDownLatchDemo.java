package com.lijinlin.project.learn.Thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lijinlin
 * @date2021年06月02日 17:09
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatchOne = new CountDownLatch(1);
        CountDownLatch countDownLatchFive = new CountDownLatch(5);

        for (int i = 0; i < 5; i++){
            new Thread(new MyRunnable(countDownLatchOne,countDownLatchFive)).start();
        }
        System.out.println("用于触发处于等待状态的线程开始工作......");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");
        countDownLatchOne.countDown();
        System.out.println("主线程" + Thread.currentThread().getName() + "状态" + Thread.currentThread().getState());
        Boolean b = countDownLatchFive.await(1, TimeUnit.SECONDS);
        System.out.println("主线程" + Thread.currentThread().getName() + "状态" + Thread.currentThread().getState());
        System.out.println("五个子线程都执行完了" + b);
        Thread.sleep(2000);
        System.out.println("主线程" + Thread.currentThread().getName() + "状态" + Thread.currentThread().getState());

    }

    public static class MyRunnable implements Runnable{
        private final CountDownLatch countDownLatchOne;
        private final CountDownLatch countDownLatchFive;

        public MyRunnable(CountDownLatch countDownLatchOne, CountDownLatch countDownLatchFive) {
            this.countDownLatchOne = countDownLatchOne;
            this.countDownLatchFive = countDownLatchFive;
        }
        @Override
        public void run() {
            try{
                System.out.println("等待主线程执行完毕，获得开始执行信号...");
                countDownLatchOne.await();
                System.out.println("处于等待的线程开始自己预期工作......");
                Thread.sleep(2000);
                countDownLatchFive.countDown();
                System.out.println("完成预期工作，发出完成信号...");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



}
