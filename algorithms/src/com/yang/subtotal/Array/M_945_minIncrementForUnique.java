package com.yang.subtotal.Array;

import java.util.Arrays;

public class M_945_minIncrementForUnique {

    //排序
    public int minIncrementForUnique_sort(int[] A) {
        Arrays.sort(A);
        int move = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]<=A[i-1]){
                int pre = A[i];
                A[i] = A[i-1]+1;
                move+=A[i]-pre;
            }
        }
        return move;
    }



    //线性探测
    int [] pos = new int[80000];
    public int minIncrementForUnique(int[] A) {
        Arrays.fill(pos,-1);
        int move = 0;
        for (int a : A) {
            int b  = posS(a);
            move += b-a;
        }
        return move;
    }
    //线性探测加动态
    public int posS(int a){
        int b = pos[a];
        if(b==-1){
            pos[a] = a;
            return a;
        }
        b = posS(b+1);
        pos[a]  = b;
        return b;
    }

}
