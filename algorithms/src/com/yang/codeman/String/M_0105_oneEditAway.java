package com.yang.codeman.String;

public class M_0105_oneEditAway {
    public static boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()){ //替换
            int num = 0;
            for (int i = 0; i < first.length(); i++) {
                if(first.charAt(i)!=second.charAt(i)) num++;
            }
            if(num<=1) return true;
            return false;
        }else if(first.length()-second.length() ==1){ //删除
            for (int i = 0; i < second.length(); i++) {
                if(first.charAt(i)!=second.charAt(i)){
                    for (int j = i; j < second.length(); j++) {
                        if(first.charAt(i+1)!=second.charAt(i)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }else if(first.length()-second.length() ==-1){ //新增
            for (int i = 0; i < first.length(); i++) {
                if(second.charAt(i)!=first.charAt(i)){
                    for (int j = i; j < first.length(); j++) {
                        if(second.charAt(i+1)!=first.charAt(i)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("abcd","a"));
    }
}
