package com.yang.subtotal.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;

/*
* 二叉树的最大宽度
* 使用层次遍历来实现
* */
public class M_662_widthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            queue.add(root);
            int res = 1;
            list.add(1);
            while (!queue.isEmpty()){
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode cur = queue.poll();
                    Integer curIndex = list.removeFirst();
                    if(cur.left!=null){
                        queue.add(cur.left);
                        list.add(curIndex*2);
                    }
                    if(cur.right!=null){
                        queue.add(cur.right);
                        list.add(curIndex*2+1);
                    }
                }
                if(list.size()>=2){
                    res = Math.max(res,list.getLast()-list.getFirst()+1);
                }
            }
            return res;
        }
        return 0;
    }
}
