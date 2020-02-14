package com.juc.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("here ");
        TimeUnit.SECONDS.sleep(4);
        return "1024";
    }
}
/*
*  callable 接口和 Runnable接口的区别
*  1. 是否有返回值
*  2. 是否抛异常
*  3. 落地方法不一样 一个是call 一个是run
* */

/*
* 多线程中第3种获得多线程的方式
* 1 . get()方法一般放在最后一行
*
* */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread2());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        System.out.println(Thread.currentThread().getName()+"...计算完成");
        System.out.println(futureTask.get());

    }
}
