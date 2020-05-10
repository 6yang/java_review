package com.yang.subtotal.number;

public class M_43_multiply {

    //字符串相乘
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int [] res = new int[n1+n2];
        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                //还要加上进位位
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+res[i+j+1];
                //叠加
                res[i+j+1] = mul%10;
                res[i+j] += mul/10;  //+++
            }
        }
        int idx= 0;
        StringBuilder ans = new StringBuilder();
        while(idx<res.length&&res[idx]==0) idx++;
        while(idx<res.length) ans.append(res[idx++]);
        return ans.length()==0?"0":ans.toString();
    }
}
