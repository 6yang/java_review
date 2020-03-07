package com.yang.jianzhi;

public class M_35_copyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head ==null) return head;
        Node cur = head;
        while(cur!=null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        cur = head;
        while(cur!=null){

            cur.next.random = cur.random==null?null:cur.random.next;
            cur = cur.next.next;
        }
        Node res = head.next;
        cur = head;
        Node copyHead = head.next;
        while(cur!=null){
            cur.next = cur.next.next;
            cur = cur.next;
            if(res.next!=null){
                res.next = res.next.next;
                res = res.next;
            }
        }
        return copyHead;
    }
}
