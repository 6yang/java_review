package com.yang.subtotal.linklist;

import java.net.CookiePolicy;

public class M_138_copyRandomList {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curNode = head;
        //第一步   插入拷贝的节点到每一个节点后面
        while(curNode!=null){
            Node node = new Node(curNode.val);
            node.next = curNode.next;
            curNode.next = node;
            curNode = curNode.next.next;
        }
        //第二步 更改随机指针
        curNode = head;
        while(curNode!=null){
            curNode.next.random = curNode.random == null ?null:curNode.random.next;
            curNode = curNode.next.next;
        }
        //第三步 将拷贝和被拷贝的链表分开
        curNode = head;
        Node copyNext = head.next;
        Node resNode = head.next;
        while(curNode!=null){
            curNode.next = curNode.next.next;
            curNode = curNode.next;
            if(copyNext.next!=null){
                copyNext.next = copyNext.next.next;
                copyNext = copyNext.next;
            }
        }
        return resNode;
    }

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
}
