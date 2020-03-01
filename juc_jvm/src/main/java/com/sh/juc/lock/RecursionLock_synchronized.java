package com.sh.juc.lock;

class Phone{
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId()+"\t send email");
        sendSms();
    }
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getId()+"\t send sms");
    }
}

public class RecursionLock_synchronized {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
           phone.sendEmail();
        },"A").start();
        new Thread(()->{
            phone.sendEmail();
        },"B").start();
    }
    //12	 send email
    //12	 send sms
    //13	 send email
    //13	 send sms
}
