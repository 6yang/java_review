package com.yang.jianzhi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class M_13_movingCount_bfs {

    public int movingCount(int m, int n, int k) {
        if(sum_i_j(m,n)<k) return  m*n;
        Queue<String> queue = new LinkedList<>();
        queue.add(0+"_"+0);
        int num =1;
        while(queue.size()>0){
            String[] x = queue.poll().split("_");
            int i=Integer.parseInt(x[0]);
            int j=Integer.parseInt(x[1]);
            if(sum_i_j(i,j+1)<=k||i<m||j<n){
                j = j+1;
                queue.add(i+"_"+j);
                num++;
            }else if(sum_i_j(i+1,j)<=k||i<m||j<n){
                i=i+1;
                queue.add(i+"_"+j);
                num++;
            }
        }
        return num;
    }


    public static int sum_i_j(int row,int col){
        int tmp =0;
        while(row>0){
            tmp+=row%10;
            row = row/10;
        }
        while(col>0){
            tmp+=col%10;
            col = col/10;
        }
        return tmp;
    }

    public static void main(String[] args) {
    }
}
