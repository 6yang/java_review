package com.yang.jianzhi;

import java.util.*;

public class M_32_III_levelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int flag = 1; //偶数层
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                if(flag == 1){
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if(node.left!=null){
                        queue.addFirst(node.left);
                    }
                    if(node.right!=null){
                        queue.addFirst(node.right);
                    }
                }
                if(flag == 0){
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if(node.right!=null){
                        queue.addLast(node.right);
                    }
                    if(node.left!=null){
                        queue.addLast(node.left);
                    }
                }
            }
            lists.add(list);
            flag = flag ==1 ?0:1;
        }
        return lists;
    }
    //队列和栈实现
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        int flag = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag == 1) {
                    list.add(node.val);
                } else {
                    stack.push(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            flag = flag == 0 ? 1 : 0;
            lists.add(list);
        }
        return lists;
    }
}
