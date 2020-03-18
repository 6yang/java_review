package com.yang.jianzhi;

public class E_42_maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int resMax = Integer.MIN_VALUE;
        int curMax = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(curMax<=0){
                curMax = nums[i];
            }else{
                curMax += nums[i];
            }
            if(curMax>resMax){
                resMax = curMax;
            }
        }
        return resMax;
    }
}
