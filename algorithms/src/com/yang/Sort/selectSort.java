package com.yang.Sort;

public class selectSort {
    public static int[] selectSort(int [] arr){
        int min,temp ;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] >arr[j]){
                    min = j;
                }
            }
            if(min!=i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,12,3,555,11,523};
        int[] ints = selectSort(arr);
        for (int s : ints) {
            System.out.print(s+" ");
        }
    }
}
