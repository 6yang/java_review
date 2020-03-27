package com.yang.subtotal.String;

public class E_0103_ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(S.charAt(i)==' '){
                str.append("%20");
            }else{
                str.append(S.charAt(i));
            }
        }
        return str.toString();
    }
}
