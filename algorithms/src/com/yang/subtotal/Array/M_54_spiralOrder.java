package com.yang.subtotal.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M_54_spiralOrder {
    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if(matrix.length==0) return res;
        int up = 0,down = matrix.length-1;
        int left = 0,right = matrix[0].length-1;
        while (true){
            for (int i = left; i <= right; i++)  res.add(matrix[up][i]);
            if(++up>down) break;
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if(--right<left)  break;
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if(--down<up) break;
            for (int i = down; i >= up; i--) res.add(matrix[i][left]);
            if(++left>right) break;;
        }
        return res;
    }
}
