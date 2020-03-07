package com.yang.jianzhi;

public class E_68_II_lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null||root ==p||root ==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return right==null?left:(left == null?right:root);
        //情况1：如果右子树找不到 p 或 q 即(right==null)，
        //那么说明 p 和 q 都在左子树上，返回 left

        //情况2：如果左子树找不到 p 或 q 即(left==null)，
        //那么说明 p 和 q 都在右子树上，返回 right

        //如果上述情况都不符合，说明 p 和 q 分别在左子树和右子树，
        //那么最近公共节点为当前节点
        //直接返回 root 即可
    }
}
