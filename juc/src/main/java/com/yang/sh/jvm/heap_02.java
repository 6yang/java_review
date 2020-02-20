package com.yang.sh.jvm;

import java.util.Random;

public class heap_02 {
    public static void main(String[] args) {
        String str = "6yang" ;
        while(true)
        {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
        }
        //[GC (Allocation Failure) [PSYoungGen: 2026K->482K(2560K)] 2026K->754K(9728K), 0.0175772 secs] [Times: user=0.00 sys=0.00, real=0.03 secs]
        //[GC (Allocation Failure) [PSYoungGen: 2412K->504K(2560K)] 2684K->1667K(9728K), 0.0008862 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[GC (Allocation Failure) [PSYoungGen: 1933K->488K(2560K)] 3097K->2355K(9728K), 0.0005578 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[GC (Allocation Failure) [PSYoungGen: 1928K->488K(2560K)] 5171K->4435K(9728K), 0.0007147 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[GC (Allocation Failure) [PSYoungGen: 1222K->472K(2560K)] 6545K->5795K(9728K), 0.0005020 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[GC (Allocation Failure) [PSYoungGen: 472K->456K(1536K)] 5795K->5779K(8704K), 0.0004721 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (Allocation Failure) [PSYoungGen: 456K->0K(1536K)] [ParOldGen: 5323K->2701K(7168K)] 5779K->2701K(8704K), [Metaspace: 3496K->3496K(1056768K)], 0.0054923 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[GC (Allocation Failure) [PSYoungGen: 50K->144K(2048K)] 6879K->6973K(9216K), 0.0005970 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (Ergonomics) [PSYoungGen: 144K->0K(2048K)] [ParOldGen: 6829K->2033K(7168K)] 6973K->2033K(9216K), [Metaspace: 3501K->3501K(1056768K)], 0.0064742 secs] [Times: user=0.02 sys=0.02, real=0.01 secs]
        //[GC (Allocation Failure) [PSYoungGen: 40K->0K(2048K)] 6201K->6160K(9216K), 0.0004383 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (Ergonomics) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 6160K->4784K(7168K)] 6160K->4784K(9216K), [Metaspace: 3502K->3502K(1056768K)], 0.0071688 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
        //[GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4784K->4784K(9216K), 0.0003575 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4784K->4764K(7168K)] 4784K->4764K(9216K), [Metaspace: 3502K->3502K(1056768K)], 0.0070246 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
        //Heap
        // PSYoungGen      total 2048K, used 50K [0x00000000ffd00000, 0x0000000100000000, 0x0000000100000000)
        //  eden space 1024K, 4% used [0x00000000ffd00000,0x00000000ffd0ca68,0x00000000ffe00000)
        //  from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
        //  to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
        // ParOldGen       total 7168K, used 4764K [0x00000000ff600000, 0x00000000ffd00000, 0x00000000ffd00000)
        //  object space 7168K, 66% used [0x00000000ff600000,0x00000000ffaa7220,0x00000000ffd00000)
        // Metaspace       used 3534K, capacity 4502K, committed 4864K, reserved 1056768K
        //  class space    used 391K, capacity 394K, committed 512K, reserved 1048576K
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //	at java.util.Arrays.copyOf(Arrays.java:3332)
        //	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
        //	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
        //	at java.lang.StringBuilder.append(StringBuilder.java:208)
        //	at com.yang.sh.jvm.heap_02.main(heap_02.java:10)

    }
}
