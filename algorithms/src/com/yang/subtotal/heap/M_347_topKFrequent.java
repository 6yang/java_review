package com.yang.subtotal.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class M_347_topKFrequent {
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->map.get(n2)-map.get(n1));
        for (Integer num : map.keySet()) {
            heap.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll());
        }
        return list;
    }
}
