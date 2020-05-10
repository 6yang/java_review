package com.yang.subtotal.Array;

import java.util.logging.Level;

public class M_209_minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while(sum>=s){
                res = Math.min(res,i+1-j);
                sum -=nums[j++];
            }
        }
        return res!=Integer.MAX_VALUE?res:0;
    }

}
