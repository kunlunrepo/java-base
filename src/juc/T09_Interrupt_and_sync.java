package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 11:59
 */
public class T09_Interrupt_and_sync {

    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           synchronized(o) {
               try {
                   TimeUnit.SECONDS.sleep(10);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(() -> {
            synchronized(o) {

            }
            System.out.println("t2 end");
        });

        t2.start();
        t2.interrupt(); // interrupt不能打断正在竞争锁的线程synchronized

    }
}
