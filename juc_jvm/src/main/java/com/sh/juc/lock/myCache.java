package com.sh.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class myCache {
    //保证可见性
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void read(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            Object re = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成"+re);
        } finally {
            readWriteLock.readLock().unlock();

        }
    }

    public void clearCache(){
        map.clear();
    }

    public static void main(String[] args) {
        myCache myCache = new myCache();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
               myCache.write(finalI+"",finalI);
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.read(finalI+"");
            },String.valueOf(i)).start();
        }
    }
}
