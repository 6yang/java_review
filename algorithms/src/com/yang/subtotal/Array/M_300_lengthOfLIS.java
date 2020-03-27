package com.yang.subtotal.Array;

public class M_300_lengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length ==0) return 0;
        int resMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int curMax = 1;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]<nums[j]){
                    curMax++;
                }
            }
            if(curMax>resMax){
                resMax = curMax;
            }
            if(nums.length-1-i<resMax){
                return resMax;
            }
        }
        return resMax;
    }

    public static void main(String[] args) {
        int [] arr ={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
