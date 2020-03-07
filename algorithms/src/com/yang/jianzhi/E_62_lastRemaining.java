package com.yang.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E_62_lastRemaining {

    //超时
    public static int lastRemaining_1(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int l = n;
        while(list.size()!=1){
            int lastIndex = 0;
            int i = (l + m) % l-1;
            list.remove(i);
            l--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {

    }
}
