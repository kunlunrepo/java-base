package juc;

import java.util.concurrent.CountDownLatch;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 14:59
 */
public class T00_IPlusPlus {

    private static long n = 0L;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        // 初始化数组中的线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
//                    synchronized(T00_IPlusPlus.class) { // 悲观锁 这个操作会被别的线程打断
                        n++;
//                    }
                }
                latch.countDown();
            });
        }

        for (Thread t : threads) {
            t.start();
        } // 100个线程启动

        latch.await(); // 等100个线程执行完

        System.out.println(n);
    }
}
