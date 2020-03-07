package com.yang.jianzhi;

public class M_14_I_cuttingRope {

    //动态规划
    public static int cuttingRope(int n) {
        int [] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }

    //贪心思想
    public static int cuttingRope_1(int n) {
        if(n<=3) return n-1;
        int a = n%3;
        int b = n/3;
        if(a == 0 ) return (int) Math.pow(3,b);
        if(a == 1 ) return (int) (Math.pow(3,b-1)*2*2);
        return (int) (Math.pow(3,b)*2);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
    }
}
