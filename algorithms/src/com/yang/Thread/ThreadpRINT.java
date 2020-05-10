package com.yang.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class shareResource{
    private  int num  =1 ; //1 “劳” 2 “ 动” 3 “节” 4 “快” 5“乐”
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private Condition c4 = lock.newCondition();
    private Condition c5 = lock.newCondition();

    public void print1(){ // 劳
        lock.lock();
        try {
            //判断
            while (num!=1){
                c1.await();
            }
            //干活
            System.out.println("劳");
            //通知
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2(){ // 动
        lock.lock();
        try {
            //判断
            while (num!=2){
                c2.await();
            }
            //干活
            System.out.println("动");
            //通知
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3(){ // 节
        lock.lock();
        try {
            //判断
            while (num!=3){
                c3.await();
            }
            //干活
            System.out.println("节");
            //通知
            num = 4;
            c4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print4(){ // 快
        lock.lock();
        try {
            //判断
            while (num!=4){
                c4.await();
            }
            //干活
            System.out.println("快");
            //通知
            num = 5;
            c5.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print5(){ // 乐
        lock.lock();
        try {
            //判断
            while (num!=5){
                c5.await();
            }
            //干活
            System.out.println("乐");
            //通知
            num = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ThreadpRINT {

    public static void main(String[] args) {
        shareResource resource = new shareResource();

        new Thread(()->{   //线程1
            while (true){
                resource.print1();
            }
        },"A").start();

        new Thread(()->{ //线程2
            while (true){
                resource.print2();
            }
        },"B").start();
        new Thread(()->{   //线程3
            while (true){
                resource.print3();
            }
        },"C").start();
        new Thread(()->{//线程4
            while (true){
                resource.print4();
            }
        },"D").start();
        new Thread(()->{ //线程5
            while (true){
                resource.print5();
            }
        },"E").start();
    }

}
