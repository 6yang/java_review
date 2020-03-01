package com.yang.jianzhi;

public class E_24_reverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode h =  new ListNode(0);
        ListNode next =head;
        ListNode temp ;
        while(next!=null){
            temp = next.next;
            next.next = h.next;
            h.next = next;
            next = temp;
        }
        return h.next;
    }
}
