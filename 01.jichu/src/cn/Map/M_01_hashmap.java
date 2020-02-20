package cn.Map;

import java.util.HashMap;
import java.util.Map;

public class M_01_hashmap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String put = map.put("1", "1");
        System.out.println(put);
        System.out.println("刘洋".hashCode());
    }

}
