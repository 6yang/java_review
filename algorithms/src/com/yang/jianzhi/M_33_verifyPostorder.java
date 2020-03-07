package com.yang.jianzhi;

import java.util.PriorityQueue;

public class M_33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length<=1) return true;
        return verify(postorder,0,postorder.length-1);
    }

    private boolean verify(int[] postorder, int left, int right) {
        if(left>=right) return true;
        int temp = left;
        while ((temp<right)&&(postorder[temp]<postorder[right])){
            temp++;
        }
        for (int i = temp; i < right; i++) {
            if(postorder[i]<postorder[right]){
                return false;
            }
        }
        return verify(postorder,left,temp-1)&&verify(postorder,temp,right-1);
    }

}
