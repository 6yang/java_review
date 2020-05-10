package com.yang.subtotal.number;

import java.util.LinkedList;
import java.util.Stack;

public class M_402_removeKdigits {
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            while(stack.size() >0 && k>0 && stack.peekLast()>digit){
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean loadZero = true;
        for (Character c : stack) {
            if(loadZero && c == '0') continue;
            sb.append(c);
        }
        return sb.length() == 0?"":sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.addLast('a');
        stack.addLast('b');
        stack.addLast('c');
        stack.addLast('d');
        System.out.println(stack.peek());
    }
}
