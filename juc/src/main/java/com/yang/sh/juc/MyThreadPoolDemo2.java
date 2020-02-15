package com.yang.sh.juc;

import java.util.concurrent.*;

public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
        DiscardPolicyTest();
    }

    private static void DiscardPolicyTest() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // 拒绝策略 new ThreadPoolExecutor.DiscardPolicy()
        /* 执行了8 个业务
        *pool-1-thread-1	 办理业务
        pool-1-thread-3	 办理业务
        pool-1-thread-2	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-5	 办理业务
        pool-1-thread-2	 办理业务
        pool-1-thread-3	 办理业务
        pool-1-thread-4	 办理业务

        * */
    }

    private static void DiscardOldestPolicyTest() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // 拒绝策略 new ThreadPoolExecutor.DiscardOldestPolicy()
        /* 执行了9个业务
        *pool-1-thread-1	 办理业务
        pool-1-thread-3	 办理业务
        pool-1-thread-2	 办理业务
        pool-1-thread-4	 办理业务
        pool-1-thread-2	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-5	 办理业务
        pool-1-thread-4	 办理业务
        pool-1-thread-3	 办理业务

        * */
    }

    private static void CallerRunsPolicyTest() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // 拒绝策略 new ThreadPoolExecutor.CallerRunsPolicy()
        /* 执行了10 个业务
        *pool-1-thread-1	 办理业务
        main	 办理业务
        pool-1-thread-4	 办理业务
        pool-1-thread-3	 办理业务
        pool-1-thread-2	 办理业务
        pool-1-thread-3	 办理业务
        pool-1-thread-5	 办理业务
        pool-1-thread-4	 办理业务
        pool-1-thread-1	 办理业务
        main	 办理业务

        * */
    }

    private static void AbortPolicyTest() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // 拒绝策略 new ThreadPoolExecutor.AbortPolicy()
        /* 执行了8 个业务  抛出异常
        * pool-1-thread-1	 办理业务
        java.util.concurrent.RejectedExecutionException: Task com.juc.concurrent.MyThreadPoolDemo2$$Lambda$1/1078694789@3b9a45b3 rejected from java.util.concurrent.ThreadPoolExecutor@7699a589[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 8]
        pool-1-thread-3	 办理业务
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
        pool-1-thread-2	 办理业务
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
        pool-1-thread-5	 办理业务
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
        pool-1-thread-3	 办理业务
            at com.juc.concurrent.MyThreadPoolDemo2.main(MyThreadPoolDemo2.java:18)
        pool-1-thread-4	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-2	 办理业务
        * */
    }
}
