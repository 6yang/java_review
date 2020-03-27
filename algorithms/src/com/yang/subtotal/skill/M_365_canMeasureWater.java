package com.yang.subtotal.skill;

import java.util.HashMap;
import java.util.Map;

public class M_365_canMeasureWater {
    // 方法一
    // 将hel设置为较大的桶，之后进入while循环，获得所有状态。
    //如果hel大于较小的桶，则hel减去较小桶的水量。
    //如果hel小于较小的桶，则hel加上最大桶的水量。
    public boolean canMeasureWater_1(int x, int y, int z) {
        if(x+y==z||z==0) return true;
        if(x+y<z) return false;
        if(x==y) return x==z;
        if(x>y){
            int c = x;
            x = y;
            y= c;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int hel =y;
        while(!map.containsKey(hel)){
            map.put(hel,1);
            hel = hel>x?(hel-x):(hel+y);
            if(hel == z) return true;
        }
        return false;
    }
    //方法二
    //贝祖定理
    //裴蜀定理（或贝祖定理）得名于法国数学家艾蒂安·裴蜀，说明了对任何整数a、b和它们的最大
    // 公约数d，关于未知数x和y的线性不定方程（称为裴蜀等式）：若a,b是整数,且gcd(a,b)=d，
    // 那么对于任意的整数x,y,ax+by都一定是d的倍数，特别地，一定存在整数x,y，使ax+by=d成立。
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y==z||z==0) return true;
        if(x+y<z) return false;
        if(x==y||y==0) return x==z;
        if(x==0) return y==z;
        return z%gcb(x,y)==0?true:false;
    }
    private int gcb(int x,int y){
        int g =1;
        int c = x>y?y:x;
        for (int i = g+1; i <= c; i++) {
            if(x%i==0&&y%i==0){
                g =i;
            }
        }
        return g;
    }
}
