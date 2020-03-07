package com.yang.jianzhi;

import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

public class E_30_MinStack {
    Stack<Integer> data ;
    Stack<Integer> minData;
    public E_30_MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if(minData.isEmpty()||minData.peek()>=x){
            minData.add(x);
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

    public int min() {
        return minData.peek();
    }
}
