package com.yang.jianzhi;
//面试题21. 调整数组顺序使奇数位于偶数前面
public class E_21_exchange {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j&&nums[i]%2==1) i++;
            while(i<j&&nums[j]%2==0) j--;
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] =temp;
        }
        return nums;
    }
}
