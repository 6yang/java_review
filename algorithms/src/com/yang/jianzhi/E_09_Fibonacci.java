package com.yang.jianzhi;

public class E_09_Fibonacci {

    public int fib_0(int n){
        if(n<=1) return n;
        return fib_0(n-1) +fib_0(n-2);
    }

    /*
    * 使用动态规划的思想
    * */
    public int fib_01(int n) {
        if(n<=1) return n;
        int[] fib = new int[n+1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] =fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
    /*
    * 优化 空间复杂度
    * */
    public int fib_02(int n){
        if(n<=1) return n;
        int fib0 = 0;
        int fib1 = 1;
        int fib = 0;
        for (int i = 2; i <=  n; i++) {
           fib = fib0+ fib1;
           fib0 = fib1;
           fib1 = fib;
        }
        return fib;
    }
    public static void main(String[] args) {
        E_09_Fibonacci de = new E_09_Fibonacci();
        System.out.println(de.fib_02(45));

    }
}
