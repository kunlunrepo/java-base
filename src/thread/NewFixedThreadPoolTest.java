package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 19:59
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(() -> {
            System.out.println("1号任务：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("2号任务：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("3号任务：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
