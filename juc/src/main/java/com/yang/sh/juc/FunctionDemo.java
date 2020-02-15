package com.yang.sh.juc;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println("Function --------------------------------------");

        Function<String,Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(function1.apply("abc"));
        Function<String ,Integer> function2 = s->{return s.length();};
        System.out.println(function2.apply("dhasdja"));

        System.out.println("Predicate --------------------------------------");

        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>2;
            }
        };
        System.out.println(predicate1.test("adas"));
        Predicate<String> predicate2 = s ->{return s.length()<2;};
        System.out.println(predicate2.test("asas"));

        System.out.println("Consumer --------------------------------------");

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("asasasas");
        Consumer<String> consumer2 = s->{System.out.println(s);};
        consumer2.accept("我来试试");

        System.out.println("Supplier --------------------------------------");

        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "sadasd";
            }
        };
        System.out.println(supplier1.get());
        Supplier<Boolean> supplier2 = ()->{return true;};
        System.out.println(supplier2.get());

    }
}
