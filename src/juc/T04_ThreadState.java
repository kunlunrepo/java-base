package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 11:22
 */
public class T04_ThreadState {

    public static void main(String[] args) throws Exception{
        Thread t1 = new MyThread();
        System.out.println("1："+t1.getState()); // NEW
        t1.start();
        t1.join();  // t1先执行 主线程才能结束
        System.out.println("3："+t1.getState()); // TERMINATED

        Thread t2 = new Thread(() -> {
            try {
                LockSupport.park(); // 阻塞t2
                System.out.println("t2 go on!");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("4："+t2.getState()); // 阻塞后的状态 WAITING

        LockSupport.unpark(t2); // 唤醒t2
        TimeUnit.SECONDS.sleep(1);
        System.out.println("5："+t2.getState()); // 唤醒后的状态 TIMED_WAITING

        final Object o = new Object();
        Thread t3 = new Thread(() -> {
            synchronized(o) {
                System.out.println("t3 得到了锁 o");
            }
        });

        new Thread(() -> {
            synchronized(o) {
//                SleepHelper
            }
        }).start();

//        SleepHelper

        t3.start();
//        SleepHelper
        System.out.println("6："+t3.getState());


    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("2："+this.getState()); // RUNNABLE
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + " ");
                System.out.println();
            }
        }
    }
}
