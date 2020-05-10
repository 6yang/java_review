package com.yang.subtotal.Array;

public class E_26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                if(j-i > 1){ //两个相邻不需要交换
                    nums[i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i+1;
    }
}
