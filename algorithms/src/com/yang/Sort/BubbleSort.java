package com.yang.Sort;

public class BubbleSort {

    public static int [] bubbleSort(int [] arr){
        if(arr.length==0||arr == null)
            return null;
        boolean swap = true;
        for (int i = 0; i < arr.length; i++) {
            swap= false;
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {3,24,77,32,1,1,3,4};
        int[] ints = bubbleSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }



}
