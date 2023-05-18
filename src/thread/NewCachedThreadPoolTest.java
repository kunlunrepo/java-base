package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 20:13
 */
public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + j);
            });
        }
        executorService.shutdown();

    }
}
