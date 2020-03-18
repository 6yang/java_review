package com.sh.basic.collection;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.HashMap;

public class LRUCache1<K,V> {
    private final int CACHE_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<K,Entry<K,V>> hashMap;

    class Entry<K,V>{
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

    public LRUCache1(int cache_size) {
        this.CACHE_SIZE = cache_size;
        hashMap = new HashMap<>();
    }
    public void put(K key, V value){
        Entry<K, V> entry = getEntry(key);
        if(entry==null){
            if(hashMap.size()>=CACHE_SIZE){
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        //有元素
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key,entry);
    }


    public V get(K key){
        Entry<K, V> entry = getEntry(key);
        if(entry==null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key){
        Entry<K, V> entry = getEntry(key);
        if(entry!=null){
            if(entry.pre!=null) entry.pre.next = entry.next;
            if(entry.next!=null) entry.next.pre = entry.pre;
            if(entry == first) first = entry.next;
            if(entry == last) last = entry.pre;
        }
        hashMap.remove(key);
    }


    private Entry<K,V> getEntry(K key){
        return hashMap.get(key);
    }

    //把最近访问的一个元素挪到第一个
    private void moveToFirst(Entry entry){
        if(entry == first) return ;
        if(entry.pre!=null) entry.pre.next =  entry.next;
        if(entry.next!=null) entry.next.pre = entry.pre;
        if(entry ==last) last = last.pre;

        if(first == null || last == null){
            first = last = entry;
            return ;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }
    //删除链表最后一个元素
    private void removeLast(){
        if(last!=null){
            last = last.pre;
            if(last ==null) first = null;
            else last.next = null;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache1<Integer,String> cache = new LRUCache1<>(5);
        cache.put(1,"1");
        cache.put(2,"2");
        cache.put(3,"3");
        cache.put(4,"4");
        cache.put(5,"5");
        System.out.println(cache.toString());
        cache.put(6,"6");
        cache.get(3);
        System.out.println(cache.toString());
        //5:5 4:4 3:3 2:2 1:1
        //3:3 6:6 5:5 4:4 2:2
    }

}
