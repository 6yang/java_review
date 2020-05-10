package com.yang.subtotal.Tree;

//求二叉树的最大深度
public class E_55_I_maxDepth {
    public int maxDepth(TreeNode root) {
        return root ==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
