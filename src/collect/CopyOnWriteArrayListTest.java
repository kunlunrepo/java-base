package collect;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 14:34
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        // 创建容器
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("集合：" + list);
        list.add(3); // 添加元素
        System.out.println("集合：" + list);
        list.addIfAbsent(33); // 添加不存在的元素
        System.out.println("集合：" + list);
    }
}
