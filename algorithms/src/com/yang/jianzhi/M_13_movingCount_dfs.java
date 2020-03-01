package com.yang.jianzhi;

import java.util.HashSet;
import java.util.Set;

public class M_13_movingCount_dfs {
    private Set<String> set = new HashSet<>();
    public int movingCount(int m, int n, int k) {
        dfs(0,0,m,n,k);
        return set.size();
    }

    private void dfs(int i, int j, int m, int n, int k) {
        if(sum_i_j(i,j)>k||i>m-1||j>n-1) return ;
        String x = i+"_"+j;
        if(set.add(x)){
            dfs(i+1,j,m,n,k);
            dfs(i,j+1,m,n,k);
        }
        return ;
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
