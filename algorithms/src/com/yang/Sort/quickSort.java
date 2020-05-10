package com.yang.Sort;

public class quickSort {
    public int[] quickSort(int [] arr,int l ,int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int tep = arr[i];
            while (i < j) {
                while (tep < arr[j] && i < j) j--;
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (tep > arr[i] && i < j) i++;
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = tep;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
        return arr;
    }
}
