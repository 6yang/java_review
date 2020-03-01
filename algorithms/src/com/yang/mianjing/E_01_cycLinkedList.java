package com.yang.mianjing;

/*
* 题目：判断一个链表是否有环
* */
public class E_01_cycLinkedList {

    public class LinkNode{
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(LinkNode head){
        if(head.next==null||head ==null){
            return false;
        }
        LinkNode slow,fast;
        slow = head;
        fast = head;
        while(fast!=null &&fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
