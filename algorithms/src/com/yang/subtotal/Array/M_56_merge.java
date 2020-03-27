package com.yang.subtotal.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 合并区间
public class M_56_merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        Arrays.sort(intervals, Comparator.comparing(x->x[0]));
        List<int []> arr = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(arr.size() == 0|| intervals[i][0]>arr.get(arr.size()-1)[1]){
                arr.add(intervals[i]);
            }else if(intervals[i][0]<=arr.get(arr.size()-1)[1] && intervals[i][1]>arr.get(arr.size()-1)[1] ){
                arr.get(arr.size()-1)[1] = intervals[i][1];
            }
        }
        int [][] res = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
