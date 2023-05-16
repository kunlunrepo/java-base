package collect;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 15:28
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建队列
        LinkedBlockingQueue aq = new LinkedBlockingQueue(3);

        // 添加元素
//        aq.add(null); // 空指针异常
//        aq.offer(null); // 空指针异常

        aq.add("aaa");
        aq.offer("bbb");
        aq.put("ccc");
        System.out.println(aq);

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
