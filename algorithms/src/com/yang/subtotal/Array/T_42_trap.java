package com.yang.subtotal.Array;

import java.awt.*;

//接雨水
public class T_42_trap {

    //双指针法
    public int trap(int[] height) {
        if(height.length<3) return 0;
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length-2;
        for (int i = 1; i < height.length - 1; i++) {
            if(height[left-1]<height[right+1]){
                maxLeft = Math.max(maxLeft,height[left-1]);
                if(maxLeft>height[left]){
                    sum = sum+(maxLeft-height[left]);
                }
                left++;
            }else{
                maxRight = Math.max(maxRight,height[right+1]);
                if(maxRight>height[right]){
                    sum = sum + (maxRight-height[right]);
                }
                right--;
            }
        }
        return sum;
    }
    //动态规划
    public int trap_2(int[] height) {
        if(height.length<3) return 0;
        int sum = 0;
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }
        for (int i = height.length-2; i >0; i--) {
            maxRight[i] = Math.max(maxRight[i-1],height[i+1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);
            if(height[i]<min){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    //方法一 按照列来求
    public int trap_1(int[] height) {
        if(height.length<3) return 0;
        int sum = 0;
        for (int i = 1; i < height.length-1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {  //找到从左边走最大的
                if(height[j]>maxLeft){
                    maxLeft = height[j];
                }
            }
            int maxRight = 0;
            for (int j = i+1; j < height.length; j++) {
                if(height[j]>maxRight){  //找到从右边走最大的
                    maxRight = height[j];
                }
            }
            int min = Math.min(maxLeft,maxRight);
            if(min >height[i]){
                sum = sum +(min - height[i]);
            }
        }
        return sum;
    }
}
