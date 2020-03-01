package com.yang.Sort;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int index = i-1;
            while (arr[index]>tmp&&index>0){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {2,32,22,44,2222,32,9,4,33};
        int[] ints = insertSort(arr);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

}
