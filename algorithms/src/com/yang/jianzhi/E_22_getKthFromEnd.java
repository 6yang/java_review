package com.yang.jianzhi;

public class E_22_getKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        int num =1;
        ListNode pre = head;
        ListNode next = head;
        while (next.next!=null){
            if(num<k){
                num++;
                next = next.next;
            }else{
                next = next.next;
                pre = pre.next;
            }
        }
        return pre;
    }
}
