package com.yang.subtotal.Array;

import java.util.ArrayList;
import java.util.List;

//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
public class M_229_majorityElement {
    //摩尔投票法 选出最多的两个元素然后判断是否大于1/3
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0|| nums == null) return res;
        int cant1 = 0,count1 = 0;
        int cant2 = 0,count2 = 0;
        for (int num : nums) {
            if(cant1 == num){
                count1++;
                continue;
            }
            if(cant2 == num){
                count2++;
                continue;
            }
            if(count1 == 0 ){
                cant1 = num;
                count1++;
                continue;
            }
            if(count2 == 0){
                cant2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;count2=0;
        for (int num : nums) {
            if(cant1 == num) count1++;
            else if(cant2 == num) count2++;
        }
        if(count1>nums.length/3) res.add(cant1);
        if(count2>nums.length/3) res.add(cant2);
        return res;
    }
}
