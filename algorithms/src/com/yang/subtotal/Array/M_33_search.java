package com.yang.subtotal.Array;

//lc 33 搜索旋转排序数组
public class M_33_search {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if(nums[mid] == target) return mid;
            if(nums[l]<=nums[mid]){   //说明前半部分是有序的
                if(target>=nums[l]&&target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{                    // 说明后半部分是有序的
                if(target>nums[mid]&&target<=nums[r]){
                    l = mid +1;
                }else{
                    r = mid -1;
                }
            }
        }
        return -1;
    }
}
