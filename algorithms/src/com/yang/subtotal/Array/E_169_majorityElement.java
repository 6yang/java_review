package com.yang.subtotal.Array;

import java.util.HashMap;
import java.util.Map;

public class E_169_majorityElement {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int count =0;
        Integer res = null ;
        for (int num : nums) {
            if(count == 0){
                res = num;
            }
            count += (res==num)?1:-1;
        }
        return res;
    }

    public int majorityElement_1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
                if(i>nums.length/2 && map.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}
