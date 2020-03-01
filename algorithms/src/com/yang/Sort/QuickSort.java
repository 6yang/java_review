package com.yang.Sort;

public class QuickSort {

    public static int[] quickSort(int [] arr,int l ,int r){
        if(l<r){
            int i = l;
            int j = r;
            int tep = arr[i];
            while (i<j){
                while(tep <arr[j] && i<j) j--;
                if(i<j){
                    arr[i] = arr[j];
                    i++;
                }
                while (tep >arr[i] && i<j) i++;
                if(i<j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] =tep;
            quickSort(arr,l,i-1);
            quickSort(arr,i+1,r);
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {2,32,22,44,2222,32,9,4,33};
        int[] ints = quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
