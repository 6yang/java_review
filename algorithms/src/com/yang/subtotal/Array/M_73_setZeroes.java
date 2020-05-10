package com.yang.subtotal.Array;

import java.util.HashSet;
import java.util.Set;

public class M_73_setZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0) return;
        int dLen = matrix.length;
        int rLen = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < dLen; i++) {
            for (int j = 0; j < rLen; j++) {
                if(matrix[i][j] ==0){
                    rows.add(j);
                    cols.add(i);
                }
            }
        }
        for (int i = 0; i < dLen; i++) {
            for (int j = 0; j < rLen; j++) {
                if(rows.contains(j) || cols.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
