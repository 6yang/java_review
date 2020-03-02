package com.yang.jianzhi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashSet;
import java.util.Set;

public class E_52_getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1!=h2){
            h1 = h1!=null?h1.next:headB;
            h2 = h2!=null?h2.next:headA;
        }
        return h1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1!=null || h2!=null){
            if(h1!=null){
                if(set.contains(h1)){
                    return h1;
                }else{
                    set.add(h1);
                    h1 = h1.next;
                }
            }
            if(h2!=null){
                if(set.contains(h2)){
                    return h2;
                }else {
                    set.add(h2);
                    h2 = h2.next;
                }
            }
        }
        return null;
    }
}
