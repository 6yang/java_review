package com.yang.subtotal.linklist;


public class E_876_middleNode {
    public ListNode middleNode(ListNode head) {
        if(head ==null) return  null;
        if(head==null||head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast==null || fast.next==null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
