package com.yang.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class E_54_kthLargest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        midOrder(root);
        return list.get(list.size() - k);
    }

    public void midOrder(TreeNode t) {
        if (t != null) {
            midOrder(t.left);
            list.add(t.val);
            midOrder(t.right);
        }
    }
}
