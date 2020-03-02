package com.yang.codeman.Array;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class E_01_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tag = target-nums[i];
            if(map.containsKey(tag)&&map.get(tag)!=i){
                return new int[]{map.get(tag),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] s = {3,2,4};
        int[] ints = twoSum(s, 6);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }
}
