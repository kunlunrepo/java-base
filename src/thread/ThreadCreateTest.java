package thread;

import thread.dto.MyCallable;
import thread.dto.MyJob;
import thread.dto.MyRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 09:43
 */
public class ThreadCreateTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方式1：通过继承thread
//        method1();

        // 方式2：通过实现runnable
//        method2();

        // 方式3：匿名内部类
//        method3();

        // 方式4：lambda方式
//        method4();

        // 方式5：实现callable
//        method5();

        // 方式6：基于线程池
    }

    private static void method5() throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();

        FutureTask futureTask = new FutureTask(myCallable);

        Thread thread = new Thread(futureTask);

        thread.start();

        Object count = futureTask.get();
        System.out.println("总和为：" + count);
    }

    private static void method4() {
        Thread thread = new Thread(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda：" + i);
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main：" + i);
        }
    }

    private static void method3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("匿名内部类：" + i);
                }
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main：" + i);
        }
    }

    private static void method2() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main：" + i);
        }
    }

    private static void method1() {
        MyJob t1 = new MyJob();
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main：" + i);
        }
        System.out.println("--------通过继承thread--------");
    }
}
