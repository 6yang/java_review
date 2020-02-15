package com.yang.sh.juc;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestResource{
    private int tag = 1;
    private int num = 1;
    private char a = 'A';
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void printNumber(){
        lock.lock();
        try {
            while (tag != 1){
                condition.await();
            }
            System.out.print(num++);
            System.out.print(num++);
            tag=0;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void printLetter(){
        lock.lock();
        try {
            while (tag == 1){
                condition.await();
            }
            System.out.print(a);
            tag=1;
            a= (char) (a+1);
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/*
* 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
*要求用线程间通信
*/
public class ThreadWaitNotifyTest1 {

    public static void main(String[] args) {

        TestResource testResource = new TestResource();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                testResource.printNumber();
            }
        },"").start();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                testResource.printLetter();
            }
        },"").start();

    }
}
