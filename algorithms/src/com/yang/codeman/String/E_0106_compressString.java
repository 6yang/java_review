package com.yang.codeman.String;

//字符串压缩。利用字符重复出现的次数，编写一种方法，
//实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
//则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
public class E_0106_compressString {

    public static  String compressString(String S) {
        if(S.isEmpty())
            return "";
        StringBuilder str = new StringBuilder();
        int num = 1;
        for (int i = 0; i < S.length()-1; i++) {
            if(S.charAt(i) == S.charAt(i+1)) {
                num++;
            }else{
                str.append(S.charAt(i));
                str.append(num);
                num = 1;
            }
        }
        str.append(S.charAt(S.length()-1));
        str.append(num);
        return str.toString().length()>S.length()?str.toString():S;
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaaabdddc"));
    }
}
