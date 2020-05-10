package com.yang.subtotal.Array;

import sun.reflect.annotation.AnnotationSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_15_threeSum {
    //1 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，
    //  数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum ，判断是否满足为 0，满足则添加进结果集
    //2 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
    //3 nums[i] == nums[i-1] 结果重复
    //4 当sum == 0 ，nums[L] == nums[L+1] 结果重复跳过
    //5 当sum == 0 ，nums[R] == nums[R--] 结果重复跳过

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<3) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]>0) break;
            if(i>0&&nums[i] == nums[i-1]) continue;
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0 ){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++;
                    while (L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if(sum<0){
                    L++;
                }else if(sum>0){
                    R--;
                }
            }
        }
        return res;
    }
}
