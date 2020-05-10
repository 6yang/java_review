package com.yang.subtotal.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_199_rightSideView {

    //dfs实现二叉树的右视图
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView_dfs(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root, int depth) {
        if(root == null) return;
        if(depth == res.size()) res.add(root.val);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }


    //bfs 实现二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i== size-1) res.add(node.val);
            }
        }
        return res;
    }
}
