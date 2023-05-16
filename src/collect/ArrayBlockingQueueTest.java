package collect;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 14:49
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建队列
        ArrayBlockingQueue aq = new ArrayBlockingQueue(3);

        // 添加元素
//        aq.add(null); // 不能添加null元素
//        aq.offer(null); // 不能添加null元素
//        aq.put(null); // 不能添加null元素

        // 添加元素
        aq.add("add");
        aq.offer("bbb");
        aq.put("ccc");
        System.out.println("阻塞队列：" + aq);

//        aq.add("ddd"); // 队列满的情况下，添加元素，出现异常
//        System.out.println("阻塞队列(offer方法)：" + aq.offer("ddd"));
//        aq.offer("ddd", 2, TimeUnit.SECONDS); // 设置最大阻塞时间
//        aq.put("ddd"); // 如果队列满，就永远阻塞
//        System.out.println("阻塞队列：" + aq);

//        System.out.println(aq.peek()); // 得到头元素但是不移除
//        System.out.println("阻塞队列：" + aq);
//
//        System.out.println(aq.poll()); // 得到头元素并且移除
//        System.out.println("阻塞队列：" + aq);

//        System.out.println(aq.take()); // 得到头元素并且移除
//        System.out.println("阻塞队列：" + aq);

        aq.clear(); // 清空元素
        System.out.println(aq);

        System.out.println(aq.peek()); // null
        System.out.println(aq.poll()); // null
        System.out.println(aq.poll(2, TimeUnit.SECONDS)); // null
        System.out.println(aq.take()); // 阻塞

    }
}
