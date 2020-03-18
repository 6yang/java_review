package com.yang.codeman.Array;

//贪心思想 ：
//记录之前的最小值
//记录当前值减去最小值
public class E_121_maxProfit {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price<minBuy){
                minBuy = price;
            }
            maxProfit = Math.max(maxProfit,price-minBuy);
        }
        return maxProfit;
    }
}
