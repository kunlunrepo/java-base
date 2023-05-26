package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-25 20:52
 */
public class ThreadLocalTest {

//    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<>(); // 跨线程不可访问
    private static ThreadLocal<Map<String, Object>> context = new InheritableThreadLocal<>(); // 跨线程可访问

    public static void main(String[] args) {
        // 初始化数据
        initData();

        // 获取数据
        Thread subThread = new Thread(() -> {
            testData();
        });
        subThread.start(); // 开子线程读取

    }

    private static void testData() {
        System.out.println("读数据线程：" + Thread.currentThread().getId());
        System.out.println("读取threadlocal中数据。。。。。。");
        System.out.println(context.get().size());
    }

    private static void initData() {
        System.out.println("放数据线程：" + Thread.currentThread().getId());
        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            paramMap.put(String.valueOf(i), "测试数据-" + i);
        }
        context.set(paramMap);
    }

    // 线程中放数据
    public static void set(Map<String, Object> map) {
        context.set(map);
    }

    // 线程中取数据
    public static Map<String, Object> get() {
        return context.get();
    }

    // 线程中删除数据
    public static void remove() {
        context.remove();
    }
}
