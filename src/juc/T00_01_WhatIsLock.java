package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 15:23
 */
public class T00_01_WhatIsLock {
    private static Object o = new Object();

    public static void main(String[] args) {

        Runnable r = () -> {
            try {
                synchronized(o) { // 加锁之后 3个线程有了顺序
                    System.out.println(Thread.currentThread().getName() + " start");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " end");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }
    }
}
