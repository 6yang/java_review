package com.yang.sh.jvm;

public class heap_01 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xms:max_memory= "+maxMemory +"字节" +maxMemory/1024/1024 +"MB");
        System.out.println("-Xms:total_memory= "+totalMemory +"字节" +totalMemory/1024/1024 +"MB");
        //-Xms:max_memory= 1029177344字节981MB
        //-Xms:total_memory= 1029177344字节981MB
        //Heap
        // PSYoungGen      total 305664K, used 20971K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
        //  eden space 262144K, 8% used [0x00000000eab00000,0x00000000ebf7afb8,0x00000000fab00000)
        //  from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
        //  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
        // ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
        //  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
        // Metaspace       used 3455K, capacity 4496K, committed 4864K, reserved 1056768K
        //  class space    used 381K, capacity 388K, committed 512K, reserved 1048576K
    }
}
