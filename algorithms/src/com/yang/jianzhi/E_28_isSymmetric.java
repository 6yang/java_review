package com.yang.jianzhi;

public class E_28_isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return test(root.left,root.right);
    }
    public boolean test(TreeNode t1,TreeNode t2){
        if (t1== null && t1 == null) {
            return true;
        }
        if (t1 == null || t1 == null) {
            return false;
        }
        return (t1.val == t2.val)&& test(t1.right,t2.left)&&test(t1.left,t2.right);
    }

}
