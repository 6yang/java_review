package com.yang.sh.jvm;



public class stack_01 {

    //Exception in thread "main" java.lang.StackOverflowError
    public static  void m1(){
        System.out.println("1");
        m1();

    }

    public static void main(String[] args) {
        System.out.println("main");
        m1();
    }
}
