package com.yang.subtotal.String;

public class E_18_strStr {

    //
    public int strStr(String haystack, String needle) {
        if(null==needle   || needle.length()==0)    return 0;
        if(null==haystack || haystack.length()==0)  return -1;
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m-n+1; i++) {
            int j;
            for ( j= 0; j < n; j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==n) return i;
        }
        return  -1;
    }
}
