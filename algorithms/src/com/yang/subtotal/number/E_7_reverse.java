package com.yang.subtotal.number;



public class E_7_reverse {
    //使用数字来实现
    public int reverse(int x) {
        int res = 0;
        while(x!=0){
            int pop = x%10;
            x /=10;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)) return 0; //判断是否溢出
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)) return 0; // 判断是否需溢出
            res = res*10 +pop;
        }
        return res;
    }

    //使用char数组来实现
    public int reverse_1(int x) {
        if(x==0) return 0;
        boolean flag = false;
        long res = 0;
        if(x<0){
            x = -x;
            flag = true;
        }
        char[] arrStr = String.valueOf(x).toCharArray();
        for (int i = 0; i < arrStr.length; i++) {
            res+= Math.pow(10,i)*(arrStr[i]-'0');
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        if(flag){
            return (int) -res;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-127%10);
    }


}
