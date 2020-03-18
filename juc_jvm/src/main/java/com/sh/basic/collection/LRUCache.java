package com.sh.basic.collection;

import sun.security.util.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private final int CACHE_SIZE;
    private final float LOAD_FACTOR = 0.75f;

    LinkedHashMap<K,V> map;

    public LRUCache(int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
        int capacity = (int) (Math.ceil(CACHE_SIZE/LOAD_FACTOR)+1);
        map = new LinkedHashMap(capacity,LOAD_FACTOR,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>CACHE_SIZE;
            }
        };
    }
    public synchronized void put(K key,V val){
        map.put(key,val);
    }
    public synchronized V get(K key){
        return map.get(key);
    }
    public synchronized void remove(K key){
        map.remove(key);
    }
    public synchronized int sizi(){
        return map.size();
    }
    public synchronized  void clear(){
        map.clear();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache(5);
        cache.put(1,"1");
        cache.put(2,"2");
        cache.put(3,"3");
        cache.put(4,"4");
        cache.put(5,"5");
        System.out.println(cache.toString());
        cache.put(6,"6");
        cache.get(3);
        System.out.println(cache.toString());
        //1:1 2:2 3:3 4:4 5:5
        //2:2 4:4 5:5 6:6 3:3
    }
}

