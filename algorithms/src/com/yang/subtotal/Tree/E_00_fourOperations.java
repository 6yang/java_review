package com.yang.subtotal.Tree;

public class E_00_fourOperations {
    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
    }
    public int comp(TreeNode p) throws Exception {
        int a,b;
        if(p!=null){
            if(p.left!=null && p.right!=null){
                a = comp(p.left);
                b = comp(p.right);
                return cal(a,b,p.val);
            }else{
                return p.val - '0';
            }
        }else {
            return 0;
        }
    }

    private int cal(int a, int b, char op) throws Exception {
        if(op == '+') return a+b;
        if(op == '-') return a-b;
        if(op == '*') return a*b;
        if(op == '/'){
            if(b==0){
                throw  new Exception();
            }
            return a/b;
        }
        return 0;
    }
}
