package thread.dto;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 09:50
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable：" + i);
        }
    }
}
