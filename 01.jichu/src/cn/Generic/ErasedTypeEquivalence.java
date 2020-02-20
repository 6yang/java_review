package cn.Generic;

import java.util.ArrayList;
import java.util.List;

public class ErasedTypeEquivalence {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class c1 =  new ArrayList<Integer>().getClass();
        Class c2 =  new ArrayList<String>().getClass();
        System.out.println(c1==c2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("+++++++++++++++");
        List<String> ls =new ArrayList<>();
        append(ls,String.class);
        System.out.println(ls);

    }
//    public static <T> void append(List<T> list ){
//        T elem = new T();
//        list.add(elem);
//
//    }
    public static <E> void append(List<E> list ,Class<E> cls) throws IllegalAccessException, InstantiationException {
        E elem = cls.newInstance();
        list.add(elem);
    }
}
