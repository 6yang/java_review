package com.yang.jianzhi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class M_59_II_MaxQueue_x {

    Queue<Integer> queue;
    Deque<Integer> maxQueue;
    public M_59_II_MaxQueue_x() {
        queue=new ArrayDeque();
        maxQueue=new ArrayDeque();
    }
    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peek();
    }
    public void push_back(int value) {
        queue.add(value);
        while(!maxQueue.isEmpty() && value>maxQueue.getLast())
            maxQueue.pollLast();
        maxQueue.add(value);
    }
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int ans=queue.poll();
        if(ans==maxQueue.peek())
            maxQueue.poll();
        return ans;
    }



}
