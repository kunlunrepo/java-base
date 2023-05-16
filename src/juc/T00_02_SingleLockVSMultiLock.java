package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 15:28
 */
public class T00_02_SingleLockVSMultiLock {

    // 锁 要是同一把锁

    private static Object o1 = new Object();
    private static Object o2 = new Object();
    private static Object o3 = new Object();

    public static void main(String[] args) {
        Runnable r1 = () -> {
            synchronized(o1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " start");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            synchronized(o2) {
                try {
                    System.out.println(Thread.currentThread().getName() + " start");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r3 = () -> {
            synchronized(o3) {
                try {
                    System.out.println(Thread.currentThread().getName() + " start");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }
}
