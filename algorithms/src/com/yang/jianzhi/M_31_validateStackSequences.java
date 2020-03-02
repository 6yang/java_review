package com.yang.jianzhi;

import java.util.Stack;

public class M_31_validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i =0;
        int j =0;
        while(i<popped.length&&j<=pushed.length){
            if(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }else{
                if(j==pushed.length){
                    return false;
                }
                stack.push(pushed[j++]);
            }
        }
        if(i==popped.length) return true;
        return false;
    }
}
