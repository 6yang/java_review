package com.yang.Sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 堆排序
        mergeSort(arr,0,arr.length-1);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }



    public static void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int [] tempArr = new int[arr.length]; //临时数组
        int center = mid +1; // 右数组第一个元素索引
        int thred = low; //临时数组的索引
        int temp = low ; // 缓存数组第一个元素的索引
        while(low<=mid&&center<=high){
            if(arr[low]<=arr[center]){
                tempArr[thred++] = arr[low++];
            }else{
                tempArr[thred++] = arr[center++];
            }
        }
        while(low<=mid){
            tempArr[thred++] = arr[low++];
        }
        while(center<= high){
            tempArr[thred++] = arr[center++];
        }
        while(temp<=high){
            arr[temp] = tempArr[temp++];
        }
    }
}
