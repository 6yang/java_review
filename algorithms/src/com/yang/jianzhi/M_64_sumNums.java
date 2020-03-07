package com.yang.jianzhi;

public class M_64_sumNums {
    public static int sumNums(int n) {
        int sum = n;
        boolean b = n>0&&((sum+=sumNums(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(10));
    }
}
