package com.yang.subtotal.Tree;

public class E_112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root== null ) return false;
        sum -=root.val;
        if((root.left==null) && (root.right == null))
            return (sum==0);
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
}
