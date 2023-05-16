package collect;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 14:24
 */
public class HashMapTest {
    public static void main(String[] args) {
        // 创建容器
        HashMap map = new HashMap();

        // 创建10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    for (int j = 0; j < 1000000; j++) {
                        map.put("test"+j, j);
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("一共需要的时间："+(endTime - startTime));
                }
            }).start();
        }
    }
}
