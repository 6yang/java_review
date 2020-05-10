package com.yang.subtotal.Array;

public class T_123_maxProfit {
    //买卖股票的最佳时机
    //使用状态机
    public int maxProfit(int[] prices) {
        if(prices == null ||prices.length==0) return 0;
        int b1 = -prices[0];
        int s1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            b1 = Math.max(b1,-prices[i]);  //第一次买入
            s1 = Math.max(s1,b1+prices[i]); //第一次卖出
            b2 = Math.max(b2,s1-prices[i]); //第二次买入
            s2 = Math.max(s2,b2+prices[i]); // 第二次卖出
        }
        return Math.max(0,s2);
    }
}
