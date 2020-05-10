package com.yang.subtotal.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }
    private void dfs(String s, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可
        if(left== 0&& right == 0){
            res.add(s);
            return;
        }
        if(left>right){ // 右边的使用多于左边的时候发生剪枝
            return;
        }
        if(left>0){
            dfs(s+"(",left-1,right,res);
        }
        if(right>0){
            dfs(s+")",left,right-1,res);
        }
    }

    //  广度优先遍历来实现
    class Node{
        private String res; // 拼接成的字符串
        private int left;   // 左括号剩下的数目
        private int right;  // 右括号剩下的数目

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> generateParenthesis_1(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("",n,n));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left==0&&node.right==0){
                res.add(node.res);
            }
            if(node.left>0){
                queue.offer(new Node(node.res+"(",node.left-1,node.right));
            }
            if(node.right>0 && node.left < node.right){ //不符合条件的被剪枝
                queue.offer(new Node(node.res+")",node.left,node.right-1));
            }
        }
        return res;
    }
}
