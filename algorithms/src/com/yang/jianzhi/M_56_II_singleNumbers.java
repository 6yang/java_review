package com.yang.jianzhi;

import com.yang.Sort.QuickSort;

import java.util.Collections;

public class M_56_II_singleNumbers {
    public int singleNumber(int[] nums) {

        quickSort(nums,0,nums.length-1);
        int count =1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=nums[i+1]&&count==1){
                return nums[i];
            }else if (nums[i]==nums[i+1]){
                count++;
            }else{
                count=1;
            }
        }
        return nums[nums.length-1];
    }

    private static void quickSort(int[] nums, int l, int r) {
        if(l<r){
            int i = l;
            int j = r;
            int tmp = nums[i];
            while(i<j){
                while(tmp<nums[j]&&i<j) j--;
                if(i<j){
                    nums[i++] = nums[j];
                }
                while(nums[i]<tmp&&i<j) i++;
                if(i<j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = tmp;
            quickSort(nums,r,i-1);
            quickSort(nums,i+1,r);
        }
    }

    public static void main(String[] args) {
        int [] arr ={4,10,4,10,2,4,10};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
