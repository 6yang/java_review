package com.yang.subtotal.String;


public class E_0102_CheckPermutation {
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int [] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if(arr[s2.charAt(i)-'a']== 0) return false;
            arr[s2.charAt(i)-'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
    }
}
