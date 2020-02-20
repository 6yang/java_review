package com.yang.jianzhi;

//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
// 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//示例 1：
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3

public class E_03_findRepeatNumber {

    /*
    * 解题思路1
    * */
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
    /*
    * 解题思路2 桶的思想
    * */
    public static int findRepeatNumber2(int[] nums) {
        if(nums == null || nums.length<0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                if(nums[nums[i]] == nums[i])
                    return nums[i];
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

    }


    public static void main(String[] args) {
        int [] a = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumber2(a));
    }
}
