package com.yang.sh.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{

    public static final Integer ADJUST_VALUE =10;

    private int begin ;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end-begin)<ADJUST_VALUE){
            for (int i = begin; i <= end; i++) {
                result = result+i;
            }
        }else{
            int middle = (begin + end) / 2;
            MyTask myTask01 = new MyTask(begin, middle);
            MyTask myTask02 = new MyTask(middle+1, end);
            myTask01.fork();
            myTask02.fork();
            result = myTask01.join()+myTask02.join();
        }
        return result;
    }
}
/*
* 计算从1 加到 100
* */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> joinTask = forkJoinPool.submit(myTask);
        Integer i = joinTask.get();
        System.out.println(i);
        forkJoinPool.shutdown();
    }
}
