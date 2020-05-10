package com.yang.subtotal.Array;

public class E_J62_lastRemaining {
    //圆圈里最后剩下的数字
    public int lastRemaining(int n, int m) {
        int pos = 0 ; // 最后留在圈的人的索引
        for (int i = 2; i <= n; i++) {
            pos = (pos + m )%i; //如果圈里面有两个人时候 ，留在圈里人的索引，倒退
        }
        return pos;
    }
}
