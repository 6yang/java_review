package com.sh.juc.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Item_1_n_semaphore {

    private int flag = 1;
    private int number =1;
    private Semaphore semaphore = new Semaphore(1);

    public void printOdd(){
        try {
            while (flag!=1){

            }
            semaphore.acquire();
            System.out.println(number++);
            flag =0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           semaphore.release();
        }

    }

    public void printEven(){
        try {
            while (flag!=0){

            }
            semaphore.acquire();
            System.out.println(number++);
            flag =1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Item_1_n_semaphore res = new Item_1_n_semaphore();
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
