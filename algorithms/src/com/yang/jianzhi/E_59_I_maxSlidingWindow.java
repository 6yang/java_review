package com.yang.jianzhi;

public class E_59_I_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        int[] res = new int[nums.length-k+1];
        res[0] = maxNumber(nums,0,k-1);
        for (int i = 1; i < nums.length-k+1; i++) {
            if(res[i-1]<nums[i+k-1]){
             res[i] = nums[i+k-1];
            }else{
                if(res[i-1]!=nums[i-1]){
                    res[i]=res[i-1];
                }else{
                    res[i] = maxNumber(nums,i,i+k-1);
                }
            }
        }
        return res;
    }
    private static int maxNumber(int [] nums,int l ,int r){
        int max = nums[l];
        while(l<r){
            if(max<nums[l+1]){
                max = nums[l+1];
            }
            l++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxNumber(nums, 0, nums.length - 1));
    }
}
