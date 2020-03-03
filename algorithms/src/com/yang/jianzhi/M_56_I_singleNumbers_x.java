package com.yang.jianzhi;

public class M_56_I_singleNumbers_x {
    public int[] singleNumbers(int[] nums) {
        int mark=0;
        int[] result = {0,0};
        for (int i = 0; i < nums.length; i++) {
            mark ^= nums[i];
        }
        mark = mark&(-mark);
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&mark)==0){
                result[0] ^=nums[i];
            }else{
                result[1] ^=nums[i];
            }
        }
        return result;
    }
}
