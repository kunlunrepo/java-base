package collect.dto;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 16:21
 */
public class User implements Delayed {

    private int id;
    private String name;
    private long endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public User(int id, String name, long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) { // 看剩余时间
        // 计算剩余时间 剩余时间<=0 证明已经到期
        return this.getEndTime() - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) { // 看谁先被移除
        // 队列中数据 到期时间的比较
        User other = (User) o;
        return ((Long)(this.getEndTime())).compareTo((Long)(other.getEndTime()));
    }

}
