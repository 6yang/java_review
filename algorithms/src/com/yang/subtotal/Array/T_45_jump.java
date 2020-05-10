package com.yang.subtotal.Array;

public class T_45_jump {
    //跳跃游戏II
    public int jump(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        while(end<nums.length){
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos,nums[i]+i);
            }
            start = end;
            end = maxPos+1;
            ans++;
        }
        return ans;
    }
    //优化
    public int jump_1(int[] nums) {
        int ans = 0;
        int maxPos= 0 ;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos,i+nums[i]);
            if(i==end){
                ans++;
                end = maxPos;
            }
        }
        return ans;
    }
}
