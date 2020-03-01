package com.yang.mianjing;

import java.util.HashSet;

/*
* 题目： 删除一个链表中的重复节点
* */
public class E_01_deleteEqualLinkNode {
    public static class ListNode{
        int val ;
        ListNode next ;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void deleteSameLinkNode(ListNode head){
        if(head == null) return;
        HashSet<Integer> sets = new HashSet<>();
        ListNode temp = head.next;
        ListNode pre = head;
        sets.add(head.val);
        while (temp.next!=null && temp != null){
            if(sets.contains(temp.val)){
                pre.next = temp.next;
                temp = temp.next;
            }else {
                sets.add(temp.val);
                pre = pre.next;
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        deleteSameLinkNode(n1);
         ListNode h1 = n1;
        while(h1!=null){
            System.out.print(h1.val+" ");
            h1 = h1.next;
        }


    }

}
