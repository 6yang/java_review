package com.yang.subtotal.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M_47_permuteUnique {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0 )return res;
        Arrays.sort(nums);    //排序
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,track,used);
        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> track,boolean[] used) {
        if(nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(i>0&&nums[i] == nums[i-1]&&!used[i-1]) continue;  //剪枝
            track.add(nums[i]);
            used[i] = true;
            dfs(nums,track,used);
            used[i] = false;
            track.removeLast();
        }
    }
}
