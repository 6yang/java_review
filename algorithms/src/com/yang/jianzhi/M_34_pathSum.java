package com.yang.jianzhi;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class M_34_pathSum {
    private List<List<Integer>> lists;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        pathBucket(root,sum,new ArrayList<Integer>());
        return lists;
    }

    private void pathBucket(TreeNode node, int sum, List<Integer> list) {
        if(node == null ) return;
        list.add(node.val);
        sum -= node.val;
        if(sum==0&&node.left==null&&node.right==null){
            lists.add(new ArrayList<>(list));
        }else{
            pathBucket(node.left,sum,list);
            pathBucket(node.right,sum,list);
        }
        list.remove(list.size()-1); //回溯
    }


}
