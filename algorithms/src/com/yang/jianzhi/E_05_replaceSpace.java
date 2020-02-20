package com.yang.jianzhi;

public class E_05_replaceSpace {
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            if(' '!=chars[i]){
                sb.append(chars[i]);
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
    public static String replaceSpace2(String s) {
        int len = s.length();
        char [] cs = new char[len*3];
        char[] c = s.toCharArray();
        int size = 0;
        for (int i = 0; i < len; i++) {
            if(c[i]==' '){
                cs[size++] = '%';
                cs[size++] = '2';
                cs[size++] = '0';
            }else{
                cs[size++] = c[i];

            }
        }
        return new String(cs,0,size);
    }



    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));

    }


}
