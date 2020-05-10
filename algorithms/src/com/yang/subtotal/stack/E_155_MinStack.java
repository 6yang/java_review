package com.yang.subtotal.stack;

import java.util.Stack;

public class E_155_MinStack {
    /** initialize your data structure here. */
    Stack<Integer> data;
    Stack<Integer> minData;
    public E_155_MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(minData.isEmpty() || minData.peek()>=x){
            minData.push(x);
        }
    }

    public void pop() {
        if(data.pop().equals(minData.peek())){
            minData.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}
