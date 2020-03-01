package com.yang.codeman.linklist;

import java.util.HashSet;
import java.util.Set;

public class E_0110_removeDuplicateNodes {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            Set<Integer> set = new HashSet<>();
            ListNode tmp = head.next;
            ListNode pre = head;
            set.add(head.val);
            while (tmp != null) {
                if (!set.add(tmp.val)) {
                    pre.next = tmp.next;
                    tmp = tmp.next;
                }else{
                    pre = pre.next;
                    tmp = tmp.next;
                }

            }
            return head;
        }

    }
