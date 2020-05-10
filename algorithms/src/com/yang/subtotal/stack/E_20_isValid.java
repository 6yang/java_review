package com.yang.subtotal.stack;

import com.sun.tracing.dtrace.StabilityLevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E_20_isValid {
    //判断是不是有效的括号
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if(pop!=map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
