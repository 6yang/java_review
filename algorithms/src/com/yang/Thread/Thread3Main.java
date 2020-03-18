package com.yang.Thread;

import java.util.concurrent.*;

//三个线程，我想让其中两个线程先执行，第三个线程在他们之后执行，main方法最后输出结束语句，
public class Thread3Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,
                3,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        Semaphore semaphore = new Semaphore(2,true);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        try {
            for (int i = 0; i < 3; i++) {
                threadPool.execute(()->{
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"得到了");
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        countDownLatch.await();
        System.out.println("主线程执行了");
    }
}
