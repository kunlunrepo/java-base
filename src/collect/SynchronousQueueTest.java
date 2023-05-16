package collect;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 15:36
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue sq = new SynchronousQueue();
//        sq.add("aaa"); // Queue full
//        sq.put("aaa"); // Queue full

        // 创建线程，take取数据 不阻塞
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(sq.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        // 创建线程，poll取数据 阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Object result = sq.poll(5, TimeUnit.SECONDS);
                        System.out.println(result);
                        if (result == null) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 创建线程，放数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sq.put("aaa");
                    sq.put("bbb");
                    sq.put("ccc");
                    sq.put("ddd");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
