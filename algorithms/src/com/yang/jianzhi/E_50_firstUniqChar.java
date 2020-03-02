package com.yang.jianzhi;



public class E_50_firstUniqChar {
    public static char firstUniqChar(String s) {
        if(s=="") return ' ';
        int [] charN = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charN[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charN[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("laaaabdd"));
    }
}
