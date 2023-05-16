package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 10:12
 */
public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();

    }

    // 暂停当前线程
    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
//                    TimeUnit.MICROSECONDS.sleep(500); // 本质也是Thread.sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    // 让一下CPU 由系统调度
    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("------B" + i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();
    }

    // join 调用join的先运行
    static void testJoin() {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // 控制了 t1先执行完再执行t2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}
