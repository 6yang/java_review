package com.yang.subtotal.Array;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.PriorityQueue;

public class M_215_findKthLargest {

    //3、自建大顶堆的方式

    public int findKthLargest(int[] nums, int k) {
        heapSort(nums,k);
        return nums[nums.length-k];
    }

    public void heapSort ( int [] nums,int k){
        int n = nums.length;
        for (int i = n / 2 - 1; i >=0 ; i--) {  //初始化堆
            heapAjust(nums,i,n);
        }
        for (int i = n - 1; i >= n-k; i--) { //堆排序的过程
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapAjust(nums,0,i);
        }
    }
    private void heapAjust(int[] nums, int low, int len) {
        int i = low;
        int j = i*2+1;
        int temp = nums[i];
        while(j<len){
            if(j!=len-1&& nums[j]<nums[j+1]) j++;
            if(temp<nums[j]){
                nums[i] = nums[j];
                i = j;
                j = i*2+1;
            }else{
                break;
            }
        }
        nums[i] = temp;
    }

    //2 .使用优先队列的方式
    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int num : nums) {
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();

    }
    //1. 使用快速排序的方式
    public int findKthLargest_1(int[] nums, int k) {
        return quickSortK(nums,0,nums.length-1,nums.length-k);
    }

    private int quickSortK(int[] arr, int l, int r, int k) {
        if(l<r) {
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
            if(i==k){
                return arr[i];
            }else if(i>k){
                return quickSortK(arr, l, i - 1, k);
            }else{
                return quickSortK(arr, i + 1, r, k);
            }
        }else {
            return -1;
        }
    }
}
