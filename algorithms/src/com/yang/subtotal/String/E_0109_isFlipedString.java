package com.yang.subtotal.String;

public class E_0109_isFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        if(s1 == s2 ) return true;
        s1+=s1;
        return s1.contains(s2);
    }
}
