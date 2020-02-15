package com.yang.sh.juc;

@FunctionalInterface
interface Foo{
    int add(int x, int y);
    default int div(int x, int y){
        System.out.println("默认方法");
        return x/y;
    }
    default int chen(int x, int y){
        System.out.println("默认方法");
        return x*y;
    }
    static void div1(int x, int y){
        System.out.println("静态乘法");
    }
    static void chen1(int x, int y){
        System.out.println("静态乘法");
    }
}

public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = (int x,int y)->{
            System.out.println("hello");
            return x+y;
        };
        int add = foo.add(10, 20);
        System.out.println(add);
        int div = foo.div(20, 10);
        System.out.println(div);
        int chen = foo.chen(10, 20);
        System.out.println(chen);
        Foo.chen1(10,20);
        Foo.div1(10,10);
    }
}
