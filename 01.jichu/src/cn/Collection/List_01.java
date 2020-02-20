package cn.Collection;

import sun.security.util.Cache;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class LRUCache <K,V> extends LinkedHashMap<K,V>{

    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return   size()>MAX_ENTRIES;
    }

    public LRUCache() {
        super(MAX_ENTRIES,0.75f,true);
    }

}


public class List_01 {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        cache.get(2);
        System.out.println(cache.keySet()); //[1, 3, 2]
        cache.put(4,"d");
        System.out.println(cache.keySet()); //[3, 2, 4]


    }

}
