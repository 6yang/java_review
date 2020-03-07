package com.yang.jianzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;

public class M_36_treeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        postOrder(root);
        list.get(0).left = list.get(list.size()-1);
        list.get(list.size()-1).right = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list.get(i-1).right = list.get(i);
            list.get(i).left = list.get(i-1);
        }
        return list.get(0);
    }

    private void postOrder(Node node) {
        if(node !=null){
            postOrder(node.left);
            list.add(node);
            postOrder(node.right);
        }

    }
}
