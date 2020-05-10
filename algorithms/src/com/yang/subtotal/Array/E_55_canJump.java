package com.yang.subtotal.Array;

public class E_55_canJump {
    public boolean canJump(int[] nums) {
        int k = 0 ;
        for (int i = 0; i < nums.length; i++) {
            //说明i 之前无论怎么跳都跳不到i
            if(i>k) return false;
            k = Math.max(k,nums[i]+i);
            if(k>nums.length) return true;
        }
        return true;
    }
}
