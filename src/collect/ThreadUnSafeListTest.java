package collect;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 13:55
 */
public class ThreadUnSafeListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        // 创建线程池
        ExecutorService es = Executors.newFixedThreadPool(100);

        // 并发向集合中添加10000个数据
        for (int i = 0; i < 10000; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("aaa");
                }
            });
        }

        // 关闭线程池
        es.shutdown();

        // 监控线程是否执行完毕
        while (true) {
            if (es.isTerminated()) { // 线程都执行完以后返回true
                System.out.println("所有的子流程都执行完毕了");
                System.out.println("执行后集合中的元素个数：" + list.size());
                if (list.size() == 10000) {
                    System.out.println("结论：线程安全");
                } else {
                    System.out.println("结论：线程不安全");
                }

                break; // 线程执行完成以后，while循环可以停止
            }
        }

    }
}
