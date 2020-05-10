package com.yang.subtotal.Array;

public class M_11_maxArea {
    //盛水最多的容器
    //
    //若向内移动短板，水槽的短板 min(h[i], h[j]) 可能变大，因此水槽面积 S(i, j)S 可能增大。
    //若向内移动长板，水槽的短板 min(h[i], h[j]) 不变或变小，下个水槽的面积一定小于当前水在每一个状态下，无论长板或短板收窄 1 格，都会导致水槽 底边宽度 -1：槽面积。
    //时间复杂度 o(n) 空间复杂度 o(1)
    public int maxArea(int[] height) {
        if(height.length==0) return 0;
        int i = 0;
        int j = height.length-1;
        int res = 0;
        while(i<j){
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            res = Math.max(res,Math.min(height[i],height[j])*(j-i));
        }
        return res;
    }
}
