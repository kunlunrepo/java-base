package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 09:59
 */
public class T01_WhatIsThread {

    private static class T1 extends Thread { // 内部类

        @Override
        public void run() {
            // 线程内部做的事
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1); // 微妙
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        new T1().start(); // 初始化并启动线程
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("main");
        }
    }
}
