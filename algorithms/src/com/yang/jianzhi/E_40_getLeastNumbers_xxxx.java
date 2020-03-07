package com.yang.jianzhi;

import java.util.PriorityQueue;

public class E_40_getLeastNumbers_xxxx {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length  == 0) return new int[]{};
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < arr.length; i++) {
            if(i<k){
                queue.add(arr[i]);
            }else{
                if(queue.peek()>arr[i]){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        queue.add(2);
        queue.add(4);
        queue.add(1);
        queue.add(1);
        queue.add(1);

        queue.add(3);
        queue.add(5);
        System.out.println(queue.peek());
        for (int i = 0; i < 5; i++) {
            System.out.print(queue.poll());
        }
    }
}
