package com.juc.concurrent;

class TestResource2{
    private int tag =1 ;
    private int num =1 ;
    private char aChar = 'A';

    public synchronized void printNumber() throws InterruptedException {

        while (tag !=1){
            this.wait();
        }
        System.out.print(num++);
        System.out.print(num++);
        tag=0;
        this.notify();
    }

    public  synchronized void printLetter() throws InterruptedException {
        while (tag==1){
            this.wait();
        }
        System.out.print(aChar);
        aChar = (char) (aChar+1);
        tag=1;
        this.notify();
    }
}


public class ThreadWaitNotifyTest2 {
    public static void main(String[] args) {
        TestResource2 testResource2 = new TestResource2();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    testResource2.printNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"").start();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    testResource2.printLetter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"").start();
    }
}
