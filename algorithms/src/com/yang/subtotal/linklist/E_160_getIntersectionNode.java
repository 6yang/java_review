package com.yang.subtotal.linklist;

public class E_160_getIntersectionNode {
    //编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        ListNode a = headA,b = headB;
        while(a!=b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;
    }
}
