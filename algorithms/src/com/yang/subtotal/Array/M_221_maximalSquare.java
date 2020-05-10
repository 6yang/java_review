package com.yang.subtotal.Array;

public class M_221_maximalSquare {
    //最大正方形， 思路动态规划
    public int maximalSquare(char[][] matrix) {
        if(matrix == null|| matrix.length == 0 || matrix[0].length ==0) return 0;
        int h = matrix.length;
        int w = matrix[0].length;
        int maxSide = 0;
        int [][] dp = new int[h+1][w+1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                    maxSide =  Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
