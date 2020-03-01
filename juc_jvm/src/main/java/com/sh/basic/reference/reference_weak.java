package com.sh.basic.reference;

import java.lang.ref.WeakReference;

public class reference_weak {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
        //发生GC即回收
        //java.lang.Object@1540e19d
        //java.lang.Object@1540e19d
        //null
        //null
    }
}
