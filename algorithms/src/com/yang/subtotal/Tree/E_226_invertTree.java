package com.yang.subtotal.Tree;

import java.util.Stack;

public class E_226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp,p;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            p = stack.pop();
            temp = p.left;
            p.left = p.right;
            p.right = temp;
            if(p.right!=null){
                stack.push(p.right);
            }
            if(p.left!=null){
                stack.push(p.left);
            }
        }
        return root;
    }
}
