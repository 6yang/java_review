package com.yang.jianzhi;

public class E_58_II_reverseLeftWords {
    //最简解
    //return s.substring(n) + s.substring(0,n);
    public String reverseLeftWords(String s, int n) {
            char[] chars = s.toCharArray();
            reverse(chars,0,s.length()-1);
            reverse(chars,0,s.length()-1-n);
            reverse(chars,s.length()-n,s.length()-1);
            return new String(chars);
        }

        public void reverse(char[] arr,int l,int r){
            char temp;
            while(l<r){
                temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
    }
}
