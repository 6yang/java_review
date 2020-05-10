package com.yang.subtotal.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M_46_permute {
    //全排列
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums,track);
        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> track) {
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) continue; //排除重复选择
            track.add(nums[i]); //做选择
            dfs(nums,track);    //进入下一层决策树
            track.removeLast(); //撤销选择
        }
    }
}
