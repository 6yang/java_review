package com.yang.subtotal.Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TreeTraversing {
    /*
    * 先序非递归
    * 使用一个栈，右边先进、左边后进
    * */
    public void preOrderNoRecursion(TreeNode root){
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode p ;
            while (!stack.isEmpty()){
                p = stack.pop();
                //visit(p);
                if(p.right!=null){
                    stack.push(p.right);
                }
                if(p.left!=null){
                    stack.push(p.left);
                }
            }
        }
    }
    /*
    * 中序非递归
    * 左孩子存在则入栈，不存在则出栈，出栈后让右孩子入栈
    * 判断条件，栈空和P！=null
    * y
    * */
    public void InOrderNoRecursion(TreeNode bt){
        if(bt!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = bt;
            while(!stack.isEmpty()|| p!=null){
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
                if(!stack.isEmpty()){
                    p = stack.pop();
                    //visit(p);
                    p = p.right;
                }
            }
        }
    }
    /*
    * 后序遍历
    * 反过来就是先序遍历先走右节点
    * 也就是说使用两个栈
    * 在栈1 进行先序遍历，不过先让左孩子进栈
    * 然后出栈以后进入栈2
    * 之后让栈2 全部出栈 就可以了
    * */
    public void postOrderNoRecursion(TreeNode bt){
        if(bt!=null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode p ;
            stack1.push(bt);
            while(!stack1.isEmpty()){
                p = stack1.pop();
                stack2.push(p);
                if(p.left!=null){
                    stack1.push(p.left);
                }
                if(p.right!=null){
                    stack1.push(p.right);
                }
            }
            while (!stack2.isEmpty()){
                p = stack2.pop();
                //visit(p);
            }
        }
    }

}
