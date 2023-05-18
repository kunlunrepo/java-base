package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 20:27
 */
public class NewWorkStealingPoolTest {

    static int[] nums = new int[1_000_000_000];

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) ((Math.random()) * 1000);
//            nums[i] = 1;
        }
    }

    public static void main(String[] args) {
        // 还有相加的和错误问题待解决

        // 单线程计算
        method1();

        // 多线程计算
        method2();

    }

    private static void method2() {
        ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        System.out.println("========多线程计算数组总和========");
        long start = System.nanoTime();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new SumRecursiveTask(0, nums.length));
        Integer result = task.join();
        long end = System.nanoTime();
        System.out.println("多线程运算结果为："+ result + ", 计算时间为："+(end - start));
    }

    private static void method1() {
        System.out.println("========单线程计算数组总和========");
        long start = System.nanoTime();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long end = System.nanoTime();
        System.out.println("单线程运算结果为："+ sum + ", 计算时间为："+(end - start));
    }


    private static class SumRecursiveTask extends RecursiveTask<Integer> {

        private int start,end;
        private final int MAX_STRIDE = 100_000_000; // 需注意是否合理

        public SumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // 在这个方法中，需要设置好任务拆分的逻辑以及聚合的逻辑
            int sum = 0;
            int stride = end - start; // 步幅
            if (stride <= MAX_STRIDE) {
                // 可以处理任务
                for (int i = start; i < end; i++) {
                    sum += nums[i]; // 拆分后的任务，实质执行的位置
                }
            } else {
                // 将任务拆分，分而治之
                int len = 10;
                int each = (start + end) / len;
                int middleStart = 0;
                // 拼接任务
                // 方式1：未提升
                SumRecursiveTask[] tasks = new SumRecursiveTask[len];
                for (int i = 0; i < len; i++) {
                    if (i == 0) {
                        // 开头
                        middleStart = each;
                        tasks[i] = new SumRecursiveTask(start, middleStart);
                    } else if (i == len-1) {
                        // 结束
                        tasks[i] = new SumRecursiveTask(middleStart+1, end);
                    } else {
                        // 中间
                        int tempStart = middleStart + 1;
                        int tempEnd = middleStart + each;
                        middleStart = tempEnd;
                        tasks[i] = new SumRecursiveTask(tempStart, tempEnd);
                    }
                }
                // 执行任务
                for (int i = 0; i < len; i++) {
                    tasks[i].fork();
                }
                // 汇总结果 获取sum
                for (int i = 0; i < len; i++) {
                    sum = sum + tasks[i].join();
                }

                // 方式2：能提升效率
//                SumRecursiveTask left = new SumRecursiveTask(start, middle);
//                SumRecursiveTask right = new SumRecursiveTask(middle+1, end);
//                // 分别执行两个任务
//                left.fork();
//                right.fork();
//                // 等待结果，并且获取sum
//                sum = left.join() + right.join();
            }
            return sum;
        }
    }


}

