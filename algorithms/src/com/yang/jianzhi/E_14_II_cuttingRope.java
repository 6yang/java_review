package com.yang.jianzhi;

public class E_14_II_cuttingRope {
    public static int cuttingRope(int n) {
        if(n<=3) return n-1;
        long mod = 1000000007;
        long res =1;
        while(n>4){
            res *=3;
            res %=mod;
            n-=3;
        }
        return (int) ((res*n)%mod);
    }

    public static void main(String[] args) {
        System.out.println(2<<31-1);
        System.out.println(cuttingRope(130));
    }
}
