package com.sh.basic.reference;

import java.lang.ref.SoftReference;

public class reference_soft {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
        //内存足够不会回收
        //java.lang.Object@1540e19d
        //java.lang.Object@1540e19d
        //null
        //java.lang.Object@1540e19d
    }
}
