package thread;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 10:15
 */
public class ThreadStateTest {
    public static void main(String[] args) {
        // 创建状态的线程
//        newThread();

        // 运行状态的线程
//        runnableThread();

        // 阻塞状态的线程
//        blockedThread();

        // 等待状态的线程
//        waitingThread();

        // 定时等待状态的线程
//        timedWaitingThread();

        // 结束状态的线程
        terminatedThread();

    }

    private static void terminatedThread() {
        try {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(1000);
            showThreadBasic(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void timedWaitingThread() {
        try {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            Thread.sleep(500);
            showThreadBasic(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitingThread() {
        try {
            Object obj = new Object();
            Thread thread = new Thread(() -> {
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            Thread.sleep(500);
            showThreadBasic(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void blockedThread() {
        try {
            Object obj = new Object();
            Thread thread = new Thread(() -> {
                synchronized (obj) { // 拿不到资源

                }
            });
            // 主线程拿到obj的锁资源
            synchronized (obj) {
                thread.start();
                Thread.sleep(500);
                showThreadBasic(thread);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runnableThread() {
        try {
            Thread thread = new Thread(() -> {
                while (true) {

                }
            });
            thread.start();
            Thread.sleep(500);
            showThreadBasic(thread);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void newThread() {
        Thread thread = new Thread(() -> {

        });
        showThreadBasic(thread);
    }

    // 基础信息
    private static void showThreadBasic(Thread thread) {
        System.out.println("--------线程基本信息*开始--------");
        System.out.println("线程-id：" + thread.getId());
        System.out.println("线程-name：" + thread.getName());
        System.out.println("线程-state：" + thread.getState());
        System.out.println("线程-priority：" + thread.getPriority());
        System.out.println("线程-threadGroup：" + thread.getThreadGroup());
        System.out.println("线程-stackTrace：" + thread.getStackTrace());
        System.out.println("线程-contextClassLoader：" + thread.getContextClassLoader());
        System.out.println("--------线程基本信息*结束--------");
    }
}
