package com.yang.Sort;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 堆排序
        heapSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void heapSort(int [] arr){
        for (int i = (arr.length-1)/ 2; i >= 0; i--) {
            heapAdjust(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            heapAdjust(arr,0,i);
        }
    }
    /*
    * 堆调整
    * */
    private static void heapAdjust(int[] arr, int low, int high) {
        int i = low;
        int j = i*2+1; //左孩子节点
        int temp = arr[i];
        while(j < high){
            if(j!=high-1 && arr[j] <arr[j+1]){
                j++;  //判断取出左右孩子中更大的那个节点
            }
            if(temp<arr[j]){
                arr[i] = arr[j];
                i = j;
                j = i*2+1;
            }else{
                break; // 左右孩子都不不小于
            }
        }
        arr[i] = temp;
    }
    /*
    * 元素交换
    * */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
