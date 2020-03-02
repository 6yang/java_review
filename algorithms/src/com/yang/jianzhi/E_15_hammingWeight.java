package com.yang.jianzhi;

public class E_15_hammingWeight {
    public static int hammingWeight(int n) {
        int tmp=0;
        while (n!=0){
            tmp+=n&1;
            n = n>>>1;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(15));
    }
}
