package com.yang.subtotal.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 合并区间
public class M_56_merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        Arrays.sort(intervals,(v1,v2)->v1[0]-v1[0]);
        List<int []> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(res.size() ==0 || intervals[i][0]>res.get(res.size()-1)[1]){
                res.add(intervals[i]);
            }else if(intervals[i][0]<=res.get(res.size()-1)[1]&&intervals[i][1]>res.get(res.size()-1)[1]){
                res.get(res.size()-1)[1] = intervals[i][1];
            }
        }
        int [][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
