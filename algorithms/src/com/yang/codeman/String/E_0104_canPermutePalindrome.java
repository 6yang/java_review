package com.yang.codeman.String;

import java.util.HashSet;
import java.util.Set;

public class E_0104_canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!set.add(s.charAt(i))){
                set.remove(s.charAt(i));
            }
        }
        if(set.size()<=1) return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
