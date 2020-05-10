package com.yang.subtotal.number;

public class E_172_trailingZeroes {
    //阶乘后的0
    public int trailingZeroes(int n) {
        int count = 0 ;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
