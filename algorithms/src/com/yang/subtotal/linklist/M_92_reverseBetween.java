package com.yang.subtotal.linklist;

import java.util.Stack;

/*
* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
* */
public class M_92_reverseBetween {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head.next;
        ListNode pre = head;
        int i = 1;
        int flag =0;
        if(m==i){
            flag =1;
            stack.push(head);
        }
        while (tmp!=null){
            i++;
            if(i>=m&&i<n){
                stack.push(tmp);
                pre.next = tmp.next;
                tmp = tmp.next;
            }else if(i == n){
                if (flag == 1){
                    head = tmp;
                }
                while (!stack.isEmpty()){
                    ListNode pop = stack.pop();
                    pop.next = tmp.next;
                    tmp.next = pop;
                    tmp = pop;
                    pre = pre.next;
                }
                return head;
            }else{
                tmp = tmp.next;
                pre = pre.next;
            }

        }
        return head;
    }
}
