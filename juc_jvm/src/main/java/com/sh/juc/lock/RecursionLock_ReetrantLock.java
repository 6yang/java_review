package com.sh.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DPhone{
    private Lock lock = new ReentrantLock();
    public  void sendEmail(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t send email");
            sendSms();
        } finally {
            lock.unlock();
        }
    }
    public void sendSms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t send sms");
        } finally {
            lock.unlock();
        }
    }
}
public class RecursionLock_ReetrantLock {
    public static void main(String[] args) {
        DPhone dPhone = new DPhone();
        new Thread(()->{
            dPhone.sendEmail();
        },"A").start();
        new Thread(()->{
            dPhone.sendEmail();
        },"B").start();
        //12	 send email
        //12	 send sms
        //13	 send email
        //13	 send sms
    }
}
