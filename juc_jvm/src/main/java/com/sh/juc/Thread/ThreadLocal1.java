package com.sh.juc.Thread;

public class ThreadLocal1 {

    private static ThreadLocal<String> threadLocal;

    public static void main(String[] args) {
        threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "初始值";
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                String name = Thread.currentThread().getName();
                System.out.println(name + "的threadLocal"+ ",设置为" + name);
                threadLocal.set(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println(name + ":" + threadLocal.get());
            },"线程 "+i+" ").start();
        }
    }
}
