package com.yang.codeman.matrix;

public class rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) { //对角线旋转
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][len-j-1];
                matrix[len-j-1][len-j-1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][j];
                matrix[len-j-1][j] = temp;
            }
        }
    }
}
