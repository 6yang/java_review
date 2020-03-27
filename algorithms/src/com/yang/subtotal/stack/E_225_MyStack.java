package com.yang.subtotal.stack;

import java.util.LinkedList;
import java.util.Queue;

//队列实现栈
public class E_225_MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public E_225_MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q1.isEmpty()){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            Integer poll = q1.poll();
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
            return  poll;
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        int pop = pop();
        q1.add(pop);
        return pop;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
}
