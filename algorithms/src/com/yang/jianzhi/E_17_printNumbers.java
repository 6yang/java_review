package com.yang.jianzhi;

import java.util.ArrayList;

public class E_17_printNumbers {
    public int[] printNumbers(int n) {
        int m = (int) Math.pow(10, 1);
        int [] arr = new int[m-1];
        for (int i = 0; i < m - 1; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
