package com.yang.jianzhi;

public class E_25_mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null) return l2==null?null:l2;
        if(l2 ==null) return l1==null?null:l1;
        ListNode l = new ListNode(0);
        ListNode ll = l;
        while(l1!=null||l2!=null){
            if(l1.val >= l2.val){
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }else{
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            }
        }
        if(l2!=null){
            l.next = l2;
        }
        if(l1!=null){
            l.next = l1;
        }
        return ll.next;

    }
}
