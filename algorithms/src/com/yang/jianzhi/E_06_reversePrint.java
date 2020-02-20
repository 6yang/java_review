package com.yang.jianzhi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

public class E_06_reversePrint {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp!=null){
            stack.push(tmp);
            tmp= tmp.next;
        }
        int size = stack.size();
        int [] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

}
