package com.lijinlin.project.learn.jvm;

public class DeadLock {
    public static void main(String[] args) {
        new DeadLock().deadLockT();
    }
    private static String A = "a";
    /**
     * 模拟死锁
     */
    private void deadLockT() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized (A){
                    try{
                        for(;;){
                            Thread.sleep(1000);
                            System.out.println("已经锁住A");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized (A){
                    System.out.println("111111");

                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized (A){
                    System.out.println("222222");

                }
            }
        }).start();
    }
}
