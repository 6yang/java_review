package com.yang.jianzhi;

public class E_16_myPow {
    public static double myPow(double x, int n) {
        if(n==0||x==1) return 1;
        int flag = n;
        if(n<0) flag = -n;
        double res=1;
        for (int i = 0; i < flag; i++) {
            res = res*x;
        }
        return n>0?res:(1/res);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
