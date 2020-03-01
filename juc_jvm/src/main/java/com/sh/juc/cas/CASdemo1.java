package com.sh.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/*
* CAS底层原理
* 自旋锁 +unsafe
* */
public class CASdemo1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"  "+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2019)+"  "+atomicInteger.get());
    }
}
