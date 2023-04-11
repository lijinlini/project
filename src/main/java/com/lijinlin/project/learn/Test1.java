package com.lijinlin.project.learn;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class Test1 {
    public static void main(String[] args) {
        Vector vector = new Vector<>();

        Container container = new Container();
        for (int a = 0; a < 2; a++) {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    container.put(i);
                    try {
                        //TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1线程" + i);
                }
            });
            t1.start();
        }

        for (int a = 0; a < 10; a++) {
            Thread t2 = new Thread(() -> {
                for (; ; ) {
                    System.out.println("t2线程" + container.get());
                    if (container.getCount() == 5) {
                        System.out.println("t2线程结束");
                        break;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
            t2.start();
        }
    }

    static class Container {
        volatile static BlockingQueue<Integer> list = new LinkedBlockingQueue<>();
        volatile int size = 30;

        void put(int i) {
            synchronized (this) {
                while (list.size() >= size) {
                    try {
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(i);
            }
        }

        int get() {
            synchronized (this) {
                try {
                    return list.take();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        }

        int getCount() {
            return list.size();
        }
    }
}
