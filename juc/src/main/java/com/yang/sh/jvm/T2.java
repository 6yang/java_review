package com.yang.sh.jvm;

public class T2 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        t1.start(); //Exception in thread "main" java.lang.IllegalThreadStateException
    }
}
