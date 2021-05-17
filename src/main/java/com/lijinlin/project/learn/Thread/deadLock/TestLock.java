package com.lijinlin.project.learn.Thread.deadLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lijinlin
 * @date2021年05月17日 21:27
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{
    int ticketNums = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                if(ticketNums>0){
                    Thread.sleep(1000);
                    ticketNums -- ;
                    System.out.println(ticketNums);
                }else {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
        System.out.println(ticketNums);
    }
}
