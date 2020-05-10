package com.yang.subtotal.Tree;

import java.util.ArrayList;
import java.util.List;

public class M_98_isValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val<= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(Long.MIN_VALUE);
    }

}
