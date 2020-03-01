package com.yang.jianzhi;

public class E_18_deleteNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        if(head.val==val) return head.next;
        ListNode pre = head;
        ListNode next = head.next;
        while(next!=null){
            if(next.val == val){
                pre.next = next.next;
                next = next.next;
            }else{
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }
}
