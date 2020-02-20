package com.yang.sh.jvm;

import java.util.concurrent.TimeUnit;

class MyNumber{

    volatile int number  =10 ;

    public void addTo1205(){
        this.number = 1025;
    }
}
/*
* JMM = 可见性（通知机制）
* */
public class Jmm_01 {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(()->{
            System.out.println("A come in ");
            try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            myNumber.addTo1205(); // 10修改为1025
            System.out.println(Thread.currentThread().getName()+"\t A update number : "+myNumber.number);

        },"A").start();

        while(myNumber.number == 10 ) {
            //需要有一种通知机制告诉main 线程 ，number已经修改为1025 ，跳出while
        }
        System.out.println(Thread.currentThread().getName()+" mission is over");

    }
}
