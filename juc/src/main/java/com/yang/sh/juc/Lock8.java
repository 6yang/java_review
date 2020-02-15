package com.yang.sh.juc;

import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("send email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void sendEms(){
        System.out.println("send sms");
    }
    public void hello(){
        System.out.println("hello");
    }
}

/*
* 多线程8锁
* 1 标准访问 先打印邮件还是先打印短信 /?  邮件
* 2 邮件方法暂停4秒   请问是先答应邮件还是短信？ 邮件
* 3 新增一个方法hello() 请问先打印邮件还是hello ? hello
* 4 两部手机， 先打印邮件还是短信？ 短信
* 5 1部手机，两个静态同步方法 先打印手机还是短信？ 邮件
* 6 2部手机，两个静态同步方法 先打印手机还是短信？ 邮件
* 7 一部手机 一个静态同步方法 一个普通同步方法，请问打印短信（静态）还是邮件 短信
* 8 2部手机 一个静态同步方法 一个普通同步方法，请问打印短信（静态）还是邮件 短信
* */

public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
           phone.sendEmail();
        },"A").start();
        new Thread(()->{
           phone2.sendEms();
        },"B").start();
    }
}
