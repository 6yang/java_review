package com.yang.subtotal.linklist;

public class M_61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode old_l = head;
        int n = 1;
        while(old_l.next!=null){
            old_l = old_l.next;
            n++;
        }
        old_l.next =  head; // 接成环形链表
        ListNode cur = head,res;
        k = k%n;
        while(k>1){
            cur = cur.next;
            k--;
        }
        res = cur.next;
        cur.next = null;
        return res;
    }
}
