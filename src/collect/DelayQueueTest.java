package collect;

import collect.dto.User;

import java.util.concurrent.DelayQueue;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 17:01
 */
public class DelayQueueTest {
    // 创建一个队列
    DelayQueue<User> dq = new DelayQueue<>();

    // 登录游戏
    public void login(User user) {
        dq.add(user);
        System.out.println("用户：["+user.getId() + "],[" + user.getName() + "]已经登录，预计下机时间为：" + user.getEndTime());
    }

    // 时间到，退出游戏，队列中移除
    public void logout() {
        // 打印队列中剩余的人
        System.out.println(dq);
        try {
            User user = dq.take();
            System.out.println("用户：["+user.getId() + "],[" + user.getName() + "]上机时间到，自动退出游戏");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 获取在线人数
    public int onlineSize() {
        return dq.size();
    }

    public static void main(String[] args) {
        // 创建测试类对象
        DelayQueueTest test = new DelayQueueTest();

        // 添加登录的用户
        test.login(new User(1, "张三", System.currentTimeMillis()+5000));
        test.login(new User(2, "李四", System.currentTimeMillis()+2000));
        test.login(new User(3, "王五", System.currentTimeMillis()+10000));

        // 监控
        while (true) {
            // 到期的话，就自动下线
            test.logout();

            // 队列中元素都被移除了的话，那么停止监控
            if (test.onlineSize() == 0) {
                break;
            }
        }

    }

}
