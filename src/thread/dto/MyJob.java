package thread.dto;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 09:44
 */
public class MyJob extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyJob：" + i);
        }
    }
}
