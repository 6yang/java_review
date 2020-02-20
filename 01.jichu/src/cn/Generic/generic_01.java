package cn.Generic;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Orange extends Fruit {}

public class generic_01 {
    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();
    static class Reader<T>{
        T readExact (List<? extends T> list){
            return list.get(0);
        }
    }
    static void f1(){
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        apples.add(new Apple());
        Fruit fruit = fruitReader.readExact(apples);
        System.out.println(fruit);
    }

    static <T> void writeExact(List<T> list,T item ){
        list.add(item);
    }
    static void f2(){
        writeExact(apples,new Apple());
        writeExact(fruits,new Apple());
    }
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f3() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }

    public static void main(String[] args) {
        f2();
        f3();

    }
}
