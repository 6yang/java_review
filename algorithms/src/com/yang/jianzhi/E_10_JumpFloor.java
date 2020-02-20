package com.yang.jianzhi;

public class E_10_JumpFloor {

    /*
    * 跳n个台阶  可以先跳1 个台阶  再跳 n-1 个台阶
    *           也可以先跳2个 台阶再跳n-2个台阶
    *           n-1 和 n-2 也可以看成子问题
    *
    * */
    public static int numWays(int n) {
        if(n==0) return 1;
        if(n<=2)
            return n;
        long j1 = 1;
        long j2 = 2;
        long tp = 0;
        for (int i = 3; i <= n; i++) {
            tp = (j1 +j2) %1000000007 ;
            j1 = j2 ;
            j2 = tp;
        }
        return (int) tp;
    }

    public static void main(String[] args) {
        System.out.println(numWays(100));
    }
}

