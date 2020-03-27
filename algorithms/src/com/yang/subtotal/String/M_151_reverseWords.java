package com.yang.subtotal.String;

public class M_151_reverseWords {
    public String reverseWords(String s) {
        if(s.isEmpty()) return s;
        String[] split = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = split.length-1; i > 0; i--) {
            if(!split[i].equals("")){
                res.append(split[i]+" ");
            }
        }
        res.append(split[0].trim());

        return res.toString();
    }

}

