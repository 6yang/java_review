package com.yang.subtotal.Array;

public class M_983_mincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int minDay = days[0];
        int maxDay = days[len-1];
        int []dp = new int[maxDay+31];  //dp数组
        for(int d = maxDay,i = len-1;d>=minDay ;d--){
            if(d == days[i]){
                dp[d] = Math.min(dp[d+1]+costs[0],dp[d+7]+costs[1]); // 一天后不包  七天后不包
                dp[d] = Math.min(dp[d+30]+costs[2],dp[d]);
                i--; //日期往前走一天
            }else{
                dp[d] = dp[d+1]; //说明不需要出门
            }
        }
        return dp[minDay];
    }
}
