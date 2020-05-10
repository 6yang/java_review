package com.yang.subtotal.Array;


import java.util.Arrays;

public class M_322_coinChange {


    //dfs优化
    int ans = Integer.MAX_VALUE;
    public int coinChange(int [] coins,int amount){
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        Arrays.sort(coins);
        dfs(coins,amount,coins.length-1,0);
        return ans == Integer.MAX_VALUE?-1:ans;
    }
    /**
     * @param coins :硬币数组
     * @param amount:需要凑成的钱数
     * @param coinIdx：当前所用硬币的下标
     * @param countCoin：目前已经选择硬币的数量
     * @return ans: 最终答案
     */
    private void dfs(int[] coins, int amount, int coinIdx, int countCoin) {
        for (int i = amount/coins[coinIdx]; i >= 0; i--) {  //先用最大的去尝试
            int remainMoney = amount- i*coins[coinIdx];  //剩余的钱
            int curCountCoin = countCoin +i;  //需要的硬币数
            if(remainMoney == 0){ //如果钱花完了，剪枝
                ans = Math.min(ans,curCountCoin);
                return;
            }
            if(coinIdx==0) return ; //最小的硬币已经无法凑成了，剪枝
            if(curCountCoin+1>=ans) return;  //再往下凑硬币数加1>=ans 剪枝 如果再往下凑的话硬币数目肯定加一
            // 选择较小的面值凑够剩余的金额
            dfs(coins,remainMoney,coinIdx-1,curCountCoin);
        }
    }


    //动态规划
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
            if(r>=0&&r<min){
                min = r+1;
            }

        }
        dp[amount] = (min == Integer.MAX_VALUE)?-1:min;
        return dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coinChange_1(new int[]{1, 2, 5}, 11));

    }
}
