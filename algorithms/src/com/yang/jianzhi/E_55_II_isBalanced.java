package com.yang.jianzhi;

import jdk.nashorn.internal.ir.ReturnNode;

public class E_55_II_isBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root ==null) return  true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }else{
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


}
