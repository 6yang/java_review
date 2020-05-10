package com.yang.subtotal.String;

//在字符串 s 中找出《第一个》只出现一次的字符。如果没有，返回一个单空格。
public class E_50_firstUniqChar {

    public char firstUniqChar(String s) {
        int [] charN = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charN[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(charN[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
