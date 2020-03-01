package com.sh.basic.collection;

import java.util.HashMap;
import java.util.UUID;

public class hashmaptest_01 {
    public static void main(String[] args) {
        final HashMap<String,String > map =new HashMap<>();
        for (int i = 0; i < 10000; i++) {
                new Thread(()->{
                   map.put(UUID.randomUUID().toString(),"");
                },String.valueOf(i)).start();
        }
    }
}
