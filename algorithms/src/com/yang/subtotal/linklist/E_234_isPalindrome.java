package com.yang.subtotal.linklist;

//判断链表是否是回文链表
public class E_234_isPalindrome {
    //反转链表
    public boolean isPalindrome(ListNode head) {
        if(head == null && head.next == null){
            return true;
        }
        ListNode slow = head,fast = head;
        ListNode p=null,pre = null;
        while (fast!=null&&fast.next==null){
            p = slow;
            slow = slow.next; //快慢遍历
            fast = fast.next.next;
            p.next = pre; //翻转前半部分
            pre = p;
        }
        if(fast!=null){    //如果是奇数跳过奇数节点
            slow = slow.next;
        }
        while(p!=null){  //前半部分和后半部分进行比较
            if(p.val!=slow.val){
                return false;
            }
            p = p.next;
            slow = slow.next;
        }
        return true;
    }
}
