package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 20:06
 */
public class NewSingleThreadExecutorTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "111");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "222");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "333");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "444");
        });
    }
}
