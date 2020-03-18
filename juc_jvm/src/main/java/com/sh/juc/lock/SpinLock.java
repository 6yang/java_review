package com.sh.juc.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {


    private AtomicReference<Thread>  atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t 进来了");
        while (!atomicReference.compareAndSet(null,thread)){

        }
        System.out.println(Thread.currentThread().getName()+"\t 获得了");

    }
    public void unMyLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t 出来了");

    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
           spinLock.myLock();
           try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
           spinLock.unMyLock();
        },"A").start();
        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(()->{
            spinLock.myLock();
            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLock.unMyLock();
        },"B").start();
    }
}
