package com.yang.subtotal.Array;

import java.util.Arrays;

public class M_16_threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums==null|| nums.length==0) return 0;
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+ nums[left] +nums[right];
                if(Math.abs(target-sum) < Math.abs(target - closest)){
                    closest = sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return closest;
                }
            }
        }
        return closest;
    }
}
