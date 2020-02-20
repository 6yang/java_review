package com.yang.jianzhi;

import java.util.Stack;

class CQueue {
    public CQueue() {

    }

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();


    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.empty()) {
            if (in.empty()) {
                return -1;
            } else {
                while (!in.empty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        } else {
            return out.pop();
        }
    }
}

public class E_08_2stackRealizeQueue {

}
