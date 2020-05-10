package com.yang.subtotal.linklist;

import java.util.HashMap;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
public class M_2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res  = new ListNode(0);
        ListNode a = l1,b = l2,c = res;
        int val,add=0;
        while(a!=null&&b!=null){
            val = (add+a.val+b.val)%10;
            c.next = new ListNode(val);
            add = (a.val+b.val+add)/10;
            c = c.next;
            a = a.next;
            b = b.next;
        }
        if(a==null&&b==null&&add!=0){
            c.next = new ListNode(add);
            c = c.next;
        }
        while(a!=null){
            val = (add+a.val)%10;
            c.next = new ListNode(val);
            add = (a.val+add)/10;
            a = a.next;
            c = c.next;
        }
        while(b!=null){
            val = (add+b.val)%10;
            c.next = new ListNode(val);
            add = (add+b.val)/10;
            b = b.next;
            c = c.next;
        }
        return res.next;
    }
}
