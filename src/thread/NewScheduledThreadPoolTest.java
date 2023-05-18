package thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 20:16
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        // 正常执行
//        pool.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + ": 1");
//        });

        // 延迟执行
//        pool.schedule(()->{
//            System.out.println(Thread.currentThread().getName()+": 2");
//        }, 5 , TimeUnit.SECONDS);

        // 周期执行
//        System.out.println(new Date(System.currentTimeMillis()));
//        pool.scheduleAtFixedRate(() -> {
//            System.out.println(Thread.currentThread().getName() + " " +new Date(System.currentTimeMillis()) + ": 3");
//        }, 2, 2, TimeUnit.SECONDS); //  间隔 period

        System.out.println(new Date(System.currentTimeMillis()));
        pool.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + " " +new Date(System.currentTimeMillis()) + ": 3");
        }, 2,1, TimeUnit.SECONDS);

    }
}
