package com.yang.jianzhi;

public class E_53_searchNumberCount {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                int count = 1;
                for (int i = mid-1; i >= l; i--) {
                    if(nums[i] == target){
                        count++;
                    }else{
                        break;
                    }
                }
                for (int i = mid+1; i <=r; i++) {
                    if(nums[i] == target){
                        count++;
                    }else{
                        break;
                    }
                }
                return count;
            }
        }
        return 0;
    }
}
