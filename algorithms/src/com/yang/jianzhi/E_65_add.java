package com.yang.jianzhi;

public class E_65_add {
    //不用加减乘除做加法
    public int add(int a, int b) {
        while(b!=0){
            int y = a^b;
            b = ((a&b)<<1);
            a = y;
        }
        return a;
    }
}
