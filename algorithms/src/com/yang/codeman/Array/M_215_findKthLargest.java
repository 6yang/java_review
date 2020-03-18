package com.yang.codeman.Array;

import java.util.PriorityQueue;

public class M_215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int num : nums) {
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();

    }


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
