package com.sh.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Item_1_n {

    private int flag = 1;
    private int number =1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void printOdd(){
        lock.lock();
        try {
            while (flag!=1){
                condition.await();
            }
            System.out.println(number++);
            flag = 0;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printEven(){
        lock.lock();
        try {
            while (flag!=0){
                condition.await();
            }
            System.out.println(number++);
            flag =1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Item_1_n res = new Item_1_n();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                res.printOdd();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                res.printEven();
            }
        },"B").start();
    }

}
