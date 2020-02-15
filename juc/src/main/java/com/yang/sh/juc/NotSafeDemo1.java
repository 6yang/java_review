package com.yang.sh.juc;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
* 题目：请举例集合是不安全的
* 1. 故障现象
* java.util.ConcurrentModificationException
*
* 2 导致原因
*
*
* 3 解决方案
*   3.1 Vector()
*   3.2 Collections.synchronizedList(new ArrayList<>())
*   3.3 new CopyOnWriteArrayList<>();
*
* 4 优化建议
*
*
* */
public class NotSafeDemo1 {
    public static void main(String[] args) {
        //构造一个空的 HashMap ，默认初始容量（16）和默认负载系数（0.75）
        Map<String,String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void SetNotSafe() {
        /*
        * hashset()底层是hashmap() add 方法调用的是 haspmap.put()方法
        * */
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet();//new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    private static void ListNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>(); //Collections.synchronizedList(new ArrayList<>()); //new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
               list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}

