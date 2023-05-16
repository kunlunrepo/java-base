package juc;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 18:06
 */
public class T02_TestHashMap {

    static HashMap<UUID, UUID> m = new HashMap<>();

    static int count = 1000000;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];
    static final int THREAD_COUNT = 100;

    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    public static void main(String[] args) {
        // -------------------写---------------------
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT]; // 线程初始化
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * (count/THREAD_COUNT));
        }

        for (Thread t : threads) {
            t.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(m.size());

        // -------------------取---------------------
        start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    m.get(keys[10]);
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static class MyThread extends Thread {
        int start; // 起始
        int gap = count/THREAD_COUNT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < start + gap; i++) {
                m.put(keys[i], values[i]);
            }
        }
    }
}
