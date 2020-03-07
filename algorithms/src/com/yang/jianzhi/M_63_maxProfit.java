package com.yang.jianzhi;

public class M_63_maxProfit {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice,prices[i]);
            profit = Math.max(profit,prices[i]-buyPrice);
        }
        return profit;
    }
}
