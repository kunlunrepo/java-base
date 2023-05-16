package collect;

import collect.dto.Student;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 15:49
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
//        PriorityBlockingQueue pq = new PriorityBlockingQueue();
//        pq.put(null); // 空指针

        PriorityBlockingQueue<Student> pq = new PriorityBlockingQueue();
        pq.put(new Student("nana", 18));
        pq.put(new Student("lulu", 11));
        pq.put(new Student("feifei", 6));
        pq.put(new Student("mingming", 21));
        System.out.println(pq);

        System.out.println("--------获取数据的时候才计算谁在前谁在后--------");
        System.out.println(pq.take());
        System.out.println(pq.take());
        System.out.println(pq.take());
        System.out.println(pq.take());

    }
}
