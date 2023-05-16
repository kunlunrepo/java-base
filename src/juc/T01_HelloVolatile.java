package juc;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-03-10 14:11
 */
public class T01_HelloVolatile {

    private static volatile boolean running = true;

    private static void m() {
        System.out.println("m start");
        while (running) {
            System.out.println("hello");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(T01_HelloVolatile::m, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
    }
}
