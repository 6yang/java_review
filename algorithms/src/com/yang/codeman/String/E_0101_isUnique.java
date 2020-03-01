package com.yang.codeman.String;

public class E_0101_isUnique {
    public static boolean isUnique(String astr) {
        char [] arr = new  char[26];
        char[] astrArr = astr.toCharArray();
        for (int i = 0; i < astr.length(); i++) {
            int t = astrArr[i] -'a';
            if(arr[t]=='\u0000'){
                arr[t] = astrArr[i];
            }else{
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isUnique("abc"));

    }
}
