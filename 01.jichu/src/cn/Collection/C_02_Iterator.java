package cn.Collection;

import java.util.*;

public class C_02_Iterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","php","c++");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            next = "sdasdas";
            System.out.println(next);
        }
        System.out.println(list);

    }
}
