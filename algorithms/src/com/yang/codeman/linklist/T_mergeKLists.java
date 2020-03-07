package com.yang.codeman.linklist;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class T_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if(list!=null){
                pqueue.add(list);
            }
        }
        while(!pqueue.isEmpty()){
            ListNode node = pqueue.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next!=null){
                pqueue.add(node.next);
            }
        }
        return head.next;
    }

    //分治合并
    public ListNode mergeKLists_1(ListNode[] lists) {
        if(lists.length ==0) return null;
        int step = 1;
        while (step<lists.length){
            for (int i = 0; i < lists.length; i+=step*2) {
                if(i+step>lists.length-1){
                    lists[i] =  mergeTwoLists(lists[i],null);
                }else{
                    lists[i] =  mergeTwoLists(lists[i],lists[i+step]);
                }
            }
            step *= 2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l,ListNode r){
        if(l == null && r == null) return null;
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (l!=null && r!=null){
            if(l.val<r.val){
                next.next = l;
                l = l.next;
            }else {
                next.next = r;
                r = r.next;
            }
            next = next.next;
        }
        if(l!=null){
            next.next =l;
        }
        if(r!=null){
            next.next = r;
        }
        return head.next;
    }

}
