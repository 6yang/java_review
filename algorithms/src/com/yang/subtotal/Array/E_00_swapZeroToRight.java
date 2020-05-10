package com.yang.subtotal.Array;

public class E_00_swapZeroToRight {

    public int[] swapZeroToRight(int [] arr){
        int i = 0,j;

        while(i<arr.length&&arr[i]!=0) i++;
        j = i+1;
        while(j<arr.length){
            if(arr[j]!=0){
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j++] = temp;
            }else {
                j++;
            }
        }
        return arr;
    }
}
