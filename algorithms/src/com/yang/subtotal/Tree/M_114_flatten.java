package com.yang.subtotal.Tree;

import javax.xml.stream.FactoryConfigurationError;

public class M_114_flatten {
    private  TreeNode pre = new TreeNode(0) ;
    public void flatten(TreeNode root) {
        if(root!=null){
            TreeNode  left = root.left;
            TreeNode right = root.right;
            pre.left = null;
            pre.right = root;
            pre = pre.right;
            flatten(left);
            flatten(right);
        }
    }
}
