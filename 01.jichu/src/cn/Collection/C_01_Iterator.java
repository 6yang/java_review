package cn.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class C_01_Iterator {
    public static void main(String[] args) {
        Collection<String> day = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            day.add(i + "_"+i*100);
        }
        Iterator<String> iterator = day.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
