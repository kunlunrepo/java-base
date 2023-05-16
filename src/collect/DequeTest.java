package collect;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 19:54
 */
public class DequeTest {
    public static void main(String[] args) {
        // 双端队列 Deque
        Deque<String> d = new LinkedList<>();
        d.offer("A");
        d.offer("B");
        d.offer("C");
        System.out.println(d);

        d.offerFirst("D"); // 头插
        d.offerLast("E"); // 尾插
        System.out.println(d);

        System.out.println(d.poll()); // 弹出一个
        System.out.println(d);

        System.out.println(d.pollFirst()); // 头弹出一个
        System.out.println(d.pollLast()); // 尾弹出一个

    }
}
