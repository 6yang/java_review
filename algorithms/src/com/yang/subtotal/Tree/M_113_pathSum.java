package com.yang.subtotal.Tree;

import java.util.ArrayList;
import java.util.List;

public class M_113_pathSum {

    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList<Integer>());
        return list;
    }

    private void dfs(TreeNode node, int sum, ArrayList<Integer> tempList) {
        if(node == null) return ;
        tempList.add(node.val);
        sum-=node.val;
        if(node.left == null && node.right ==null&&sum==0){
            list.add(tempList);
        }
        dfs(node.left,sum,new ArrayList<>(tempList));
        dfs(node.right,sum,new ArrayList<>(tempList));
    }
}
