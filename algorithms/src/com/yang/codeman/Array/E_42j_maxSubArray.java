package com.yang.codeman.Array;

/*
* 最大子数组和
* */
public class E_42j_maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE;
        int curMax= 0;
        for (int i = 0; i < nums.length; i++) {
            if(curMax<0){
                curMax = nums[i];
            }else {
                curMax += nums[i];
            }
            if(max<curMax){
                max = curMax;
            }
        }
        return max;
    }
}
