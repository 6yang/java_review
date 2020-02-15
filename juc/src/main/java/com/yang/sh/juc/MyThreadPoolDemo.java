package com.yang.sh.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        newCachedThreadPool();
    }

    private static void newCachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    try { TimeUnit.MILLISECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务 ");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        /*
        * pool-1-thread-1	 办理业务
            pool-1-thread-9	 办理业务
            pool-1-thread-8	 办理业务
            pool-1-thread-5	 办理业务
            pool-1-thread-3	 办理业务
            pool-1-thread-7	 办理业务
            pool-1-thread-2	 办理业务
            pool-1-thread-6	 办理业务
            pool-1-thread-4	 办理业务
            pool-1-thread-10	 办理业务
        * */
    }

    private static void newSingleThreadExectorTest() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池单线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        /*执行结果
        * pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        pool-1-thread-1	 办理业务
        * */
    }

    private static void newFixedThreadPoolTest() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个受理线程 ，类似一个银行5和受理窗口
        try {
            for (int i = 1; i <= 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        /* 执行结果
        *   pool-1-thread-1	 办理业务
            pool-1-thread-2	 办理业务
            pool-1-thread-3	 办理业务
            pool-1-thread-4	 办理业务
            pool-1-thread-5	 办理业务
            pool-1-thread-1	 办理业务
            pool-1-thread-2	 办理业务
            pool-1-thread-3	 办理业务
            pool-1-thread-4	 办理业务
            pool-1-thread-5	 办理业务
        * */
    }


}
