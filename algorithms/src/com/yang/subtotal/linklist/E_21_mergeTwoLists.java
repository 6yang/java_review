package com.yang.subtotal.linklist;

public class E_21_mergeTwoLists {
    //迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res,q1 = l1 ,q2 = l2;
        while(q1!=null&&q2!=null){
            if(q1.val<q2.val){
                p.next = q1;
                q1 = q1.next;
            }else{
                p.next = q2;
                q2 = q2.next;
            }
            p = p.next;
        }
        if(q1!=null){
            p.next = q1;
        }
        if(q2!=null){
            p.next = q2;
        }
        return res.next;
    }
    //递归
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next = mergeTwoLists_1(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_1(l1,l2.next);
            return l2;
        }
    }
}
