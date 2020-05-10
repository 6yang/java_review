package com.yang.subtotal.String;

public class E_8_myAtoi {

    /*
    * 基本思路
    * 1 先去除两边的括号
    * 2 然后判断正负号
    * 3 识别数字 ，处理越界情况
    * */
    public int myAtoi(String str) {
        char[] strChar = str.trim().toCharArray();
        if(strChar.length==0) return 0;
        int idx = 0;
        boolean negative = false;
        if(strChar[idx]=='-'){
            idx++;
            negative = true;
        }else  if(strChar[idx] == '+'){
            idx++;
        }else if(!Character.isDigit(strChar[idx])){
            return 0;
        }
        int ans = 0;
        //用负数保存正负数的边界，这样不会溢出
        //正数 -2147483647
        //负数 -2147483648
        int limit = negative?Integer.MIN_VALUE:-Integer.MAX_VALUE;
        while(idx<strChar.length && Character.isDigit(strChar[idx])){
            int digit = strChar[idx] - '0';
            if(ans<(limit+digit)/10){  //溢出处理
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans*10 -digit; //用减法；
            idx++;
        }
        return negative?ans:-ans; // 也要反过来
    }
}
