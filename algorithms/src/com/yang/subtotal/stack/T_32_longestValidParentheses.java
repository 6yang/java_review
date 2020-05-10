package com.yang.subtotal.stack;

import java.util.Stack;

public class T_32_longestValidParentheses {
    //最长有效括号
    public int longestValidParentheses(String s) {
        if(s==null ||s.length()<2) return 0 ;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = max>(i-stack.peek())?max:(i-stack.peek());
                }
            }
        }
        return max;
    }
}
