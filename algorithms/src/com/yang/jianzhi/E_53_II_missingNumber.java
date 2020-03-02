package com.yang.jianzhi;

public class E_53_II_missingNumber {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>mid){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
