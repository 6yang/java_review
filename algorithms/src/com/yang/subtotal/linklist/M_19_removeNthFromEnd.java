package com.yang.subtotal.linklist;

public class M_19_removeNthFromEnd {
    // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //头结点之前加一个pre
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre,slow = pre;
        while(n!=0){
            fast = fast.next;
            n--;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
