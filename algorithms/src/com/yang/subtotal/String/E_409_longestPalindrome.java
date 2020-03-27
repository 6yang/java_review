package com.yang.subtotal.String;

public class E_409_longestPalindrome {

    public int longestPalindrome(String s) {
        int [] abc = new int[58];
        for (char c : s.toCharArray()) {
            abc[c-'A']++;
        }
        int count = 0 ,fg=0;
        for (int i = 0; i < 58; i++) {
            if(abc[i]!=0){
                if(abc[i]%2 ==0){
                    count+=abc[i];
                }else{
                    fg = 1;
                    count+=abc[i]-1;
                }
            }
        }
        if(fg==1) count++;
        return count;

    }

    public static void main(String[] args) {
        System.out.println('c'-'C');
    }
}
