package com.yang.subtotal.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class abc_thread {

    private int num = 1;
    private Lock lock =  new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    private void print_A(){
        lock.lock();
        try {
            while(num!=1){
                c1.await();
            }
            System.out.print("a");
            num=2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    private void print_B(){
        lock.lock();
        try {
            while(num!=2){
                c2.await();
            }
            System.out.print("b");
            num=3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    private void print_C(){
        lock.lock();
        try {
            while(num!=3){
                c3.await();
            }
            System.out.print("c");
            num=1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        abc_thread thread = new abc_thread();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                thread.print_A();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                thread.print_B();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                thread.print_C();
            }
        },"C").start();
    }
}
