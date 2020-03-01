package com.yang.Sort;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static  int[] bucketSort(int[] arr){
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int bucketNum = (max - min)/ arr.length +1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            int bk = (arr[i]-min)/arr.length+1;
            buckets.get(bk-1).add(arr[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(buckets.get(i));
            if(buckets.get(i).size()>0){
                for (int j = 0;  j< buckets.get(i).size(); j++) {
                    System.out.print(buckets.get(i).get(j)+" ");
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] arr = {2,32,22,44,32,9,4,33};
        bucketSort(arr);
    }

}
