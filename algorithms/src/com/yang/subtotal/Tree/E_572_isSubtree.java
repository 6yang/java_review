package com.yang.subtotal.Tree;

public class E_572_isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        return  checkSub(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t) ;
    }

    private boolean checkSub(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t==null) return false;
        if(s.val != t.val) return false;
        return checkSub(s.left,t.left) && checkSub(s.right,t.right);
    }
}
