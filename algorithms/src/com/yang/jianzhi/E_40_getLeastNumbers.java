package com.yang.jianzhi;

public class E_40_getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0 ) return new int[]{};
        quickSortK(arr,0,arr.length-1,k);
        int []res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSortK(int[] arr, int low, int high, int k) {
        if(low<high){
            int i = low;
            int j = high;
            int temp = arr[i];
            if(i == k) return ;
            while(i<j){
                while(i<j&&temp<arr[j]) j--;
                if(i<j){
                    arr[i] = arr[j];
                    i++;
                }
                while(i<j&&temp>arr[i]) i++;
                if(i<j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = temp;
            quickSortK(arr,low,i-1,k);
            if(k>i){
                quickSortK(arr,i+1,high,k);
            }
        }
    }
}
