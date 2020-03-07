package com.yang.jianzhi;

import java.net.Inet4Address;

public class E_49_nthUglyNumber {
    public static int nthUglyNumber(int n) {
        int [] uglys = new int[n];
        int p2 =0;int p3 =0;int p5 =0;
        uglys[0] =1 ;
        for (int i = 1; i < n; i++) {
            uglys[i] = Math.min(Math.min(uglys[p2]*2,uglys[p3]*3),uglys[p5]*5);
            if(uglys[i]==uglys[p2]*2) p2++;
            if(uglys[i]==uglys[p3]*3) p3++;
            if(uglys[i]==uglys[p5]*5) p5++;
        }
        return uglys[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }
}
