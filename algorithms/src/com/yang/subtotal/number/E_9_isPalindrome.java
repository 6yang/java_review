package com.yang.subtotal.number;

public class E_9_isPalindrome {

    //判断一个数字是否是回文数
    public boolean isPalindrome(int x) {
        //如果是负数不是
        //如果是10的倍数不是
        if(x<0||(x%10==0&&x!=0)) return false;
        //逆转一半，来判断逆转的这一半和另外一般是否相同
        int reverseNumber = 0;
        while(x>reverseNumber){
            reverseNumber = reverseNumber*10 + x%10;
            x/=10;
        }
        return x==reverseNumber || reverseNumber/10==x;
    }
}
