package com.yang.codeman.Array;



public class M_322_coinChange {
    public static int coinChange_1(int[] coins, int amount) {
        if(amount<1) return 0;
        return coinChange_1(coins,amount,new int[amount+1]);
    }

    private static int coinChange_1(int[] coins, int amount, int[] dp) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        if(dp[amount]!=0) return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int r = coinChange_1(coins, amount-coin,dp);
            if(r<0) continue;
            min = Math.min(min, r + 1);
        }
        dp[amount] = (min == Integer.MAX_VALUE)?-1:min;
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange_1(new int[]{1, 2, 5}, 11));
    }
}
