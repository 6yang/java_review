package com.yang.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class E_57_II_findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int slow = 1;
        int fast = 2;
        List<int[]> list = new ArrayList<>();
        int sum = slow+fast;
        while(slow<fast && fast<target){
            if(sum < target){
                sum +=++fast;
            }else if(sum>target){
                sum -=slow++;
            }else{
                int[] arr = new int[fast - slow + 1];
                for (int i = slow; i <= fast; i++) {
                    arr[i-slow] = i;
                }
                list.add(arr);
                slow++;
            }
        }
        return list.toArray(new int[0][]);

    }


}
