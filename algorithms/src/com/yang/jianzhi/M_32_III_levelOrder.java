package com.yang.jianzhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class E_32_levelOrder {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
    }
}
