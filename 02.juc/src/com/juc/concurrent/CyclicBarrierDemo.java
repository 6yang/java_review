package com.juc.concurrent;

        import java.util.concurrent.BrokenBarrierException;
        import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("**召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"得到第"+ finalI +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
/*
1得到第1颗龙珠
5得到第5颗龙珠
6得到第6颗龙珠
4得到第4颗龙珠
3得到第3颗龙珠
2得到第2颗龙珠
7得到第7颗龙珠
**召唤神龙
* */
