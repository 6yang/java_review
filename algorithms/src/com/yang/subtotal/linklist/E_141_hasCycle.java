package com.yang.subtotal.linklist;

public class E_141_hasCycle {
    //1 、hash表的方式
    //2 、快慢指针的方式
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast= head,slow = head;
        while(fast!=null||fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
