package com.sh.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class reference_phantom {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);

        System.out.println(o1); //java.lang.Object@1540e19d
        System.out.println(phantomReference.get()); //null
        System.out.println(queue.poll());//null
        o1 = null;
        System.gc();
        System.out.println(o1);//null
        System.out.println(phantomReference.get());//null
        System.out.println(queue.poll());//java.lang.ref.PhantomReference@677327b6

    }
}
