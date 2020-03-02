package com.yang.jianzhi;




public class E_39_majorityElement {
    public int majorityElement(int[] nums) {
        nums = quickSort_m(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    private int[]  quickSort_m(int[] nums, int l, int r) {
        if(l<r){
            int i = l;
            int j = r;
            int tmp = nums[i];
            while (i<j){
                while (tmp<nums[j]&&i<j) j--;
                if(i<j){
                    nums[i++] = nums[j];
                }
                while (tmp>nums[i]&&i<j) i++;
                if(i<j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = tmp;
            quickSort_m(nums,l,i-1);
            quickSort_m(nums,i+1,r);
        }
        return nums;
    }


}
