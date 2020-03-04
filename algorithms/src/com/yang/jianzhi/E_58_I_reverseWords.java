package com.yang.jianzhi;

public class E_58_I_reverseWords {
    public static String reverseWords(String s) {
        if(s.isEmpty()) return s;
        String[] split = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = split.length-1; i >0; i--) {
            if(!split[i].equals("")){
                res.append(split[i]+" ");
            }
        }
        res.append(split[0]);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello         world!  "));
    }

}
