package com.yang.jianzhi;

public class E_61_isStraight {
    public boolean isStraight(int[] nums) {
        quickSort(nums,0,nums.length-1);
        int flag = 0;
        int i = 0;
        while(i<nums.length-1){
            if(nums[i] == 0){
                flag --;
                i++;
            }else if(nums[i] == nums[i+1]){
                return false;
            }else if(nums[i]+1!= nums[i+1]){
                flag = flag + nums[i+1]-nums[i]-1;
                i++;
            }else{
                i++;
            }
        }
        if(flag<=0) return true;
        return false;
    }

    public void quickSort(int[] nums,int low,int high){
        if(low<high){
            int i = low;
            int j = high;
            int temp = nums[i];
            while(i<j){
                while(temp<nums[j]&&i<j) j--;
                if(i<j){
                    nums[i++] = nums[j];
                }
                while(temp>nums[i]&& i<j) i++;
                if(i<j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = temp;
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);
        }
    }

    public static void main(String[] args) {
        int [] a = {0,0,0,3,7};
//        System.out.println(isStraight(a));
    }
}
