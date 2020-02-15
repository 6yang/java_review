package com.yang.sh.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回 update mysql OK");
        });
        System.out.println(completableFuture.get());  //没有返回值 null
        //ForkJoinPool.commonPool-worker-1没有返回 update mysql OK
        //null
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回 update mysql OK");
            int age = 10/0;
            return 1024;
        });
        
        Integer i = completableFuture1.whenComplete((t, u) -> {
            System.out.println("*********t:" + t);
            System.out.println("*********u:" + u);
        }).exceptionally(f -> {
            System.out.println("*******Excepution:" + f.getMessage());
            return 444;
        }).get();
        System.out.println(i);
        /*
        * 正常执行
        *   ForkJoinPool.commonPool-worker-1没有返回 update mysql OK
            null
            ForkJoinPool.commonPool-worker-1有返回 update mysql OK
            *********t:1024
            *********u:null
            1024
        * */
        /*
        * 异常
        *   ForkJoinPool.commonPool-worker-1没有返回 update mysql OK
            null
            ForkJoinPool.commonPool-worker-1有返回 update mysql OK
            *********t:null
            *********u:java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            *******Excepution:java.lang.ArithmeticException: / by zero
            444
        * */
    }
}
