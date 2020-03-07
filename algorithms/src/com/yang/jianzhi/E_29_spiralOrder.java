package com.yang.jianzhi;


public class E_29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[]{};
        int[] res = new int[matrix.length * matrix[0].length];
        int idx = 0;
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) res[idx++] = matrix[top][i];
            top++;
            if(left>right) break;
            for (int i = top; i <= bottom; i++) res[idx++] = matrix[i][right];
            right--;
            if(top>bottom) break;
            for (int i = right; i >= left; i--) res[idx++] = matrix[bottom][i];
            bottom--;
            if(left>right) break;
            for (int i = bottom; i >=top ; i--) res[idx++] = matrix[i][left];
            left++;
            if(top>bottom) break;
        }
        return res;
    }

}
