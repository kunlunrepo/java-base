package thread;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 11:03
 */
public class ThreadUseMethodTest {
    public static void main(String[] args) {
        // 获取当前线程
//        getCurrentThread();

        // 设置线程名称
//        setThreadName();

        // 设置线程优先级
//        setThreadPriority();

        // 设置线程让步
//        setThreadYield();

        // 设置线程睡眠
//        setThreadSleep();

        // 设置线程等待
//        setThreadJoin();

        // 设置守护线程
//        setThreadDaemon();

        // 设置等待和唤醒线程
//        setThreadNotifyAll();

        // 打断线程
//        setThreadStop();
        setThreadStop2();

    }

    private static void setThreadStop2() {
        try {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("基于打断形式结束当前线程");
                        return;
                    }
                }
            });
            thread.start();
            Thread.sleep(500);
            thread.interrupt(); // 中断
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void setThreadStop() {
        try {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {

                }
                System.out.println("t1结束");
            });
            thread.start();
            Thread.sleep(500);
            thread.interrupt(); // 中断
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void setThreadNotifyAll() {
        try {
            Thread thread1 = new Thread(() -> {
                sync();
            }, "t1");
            Thread thread2 = new Thread(() -> {
                sync();
            }, "t2");

            thread1.start();
            thread2.start();
            Thread.sleep(12000);
            synchronized (ThreadUseMethodTest.class) {
                ThreadUseMethodTest.class.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sync() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    ThreadUseMethodTest.class.wait();
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
    }

    private static void setThreadDaemon() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true); // 设置守护线程
        thread.start();
    }

    private static void setThreadJoin() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1) {
                try {
                    thread.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void setThreadSleep() {
        try {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void setThreadYield() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i == 50) {
                    Thread.yield();
                }
                System.out.println("t1：" + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2：" + i);
            }
        });
        thread2.start();
        thread1.start();
    }

    private static void setThreadPriority() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t1：" + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t2：" + i);
            }
        });
        thread1.setPriority(1);
        thread2.setPriority(10);
        thread2.start();
        thread1.start();
    }

    private static void setThreadName() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.setName("模块-功能-计数器");
        thread.start();
        showThreadBasic(thread);
    }

    private static void getCurrentThread() {
        Thread thread = Thread.currentThread(); // 获取当前线程
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
