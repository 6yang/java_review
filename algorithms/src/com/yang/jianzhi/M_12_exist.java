package com.yang.jianzhi;


public class M_12_exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if(i<0||j<0||board.length<i||board[0].length<j||board[i][j]!=words[k]) return false;
        if(words.length-1 ==k) return true;
        char tmp = board[i][j];
        board[i][j] ='*';
        boolean res = dfs(board,words,i+1,j,k+1) ||dfs(board,words,i,j+1,k+1)||
                dfs(board,words,i-1,j,k+1)||dfs(board,words,i,j-1,k+1);
        board[i][j] = tmp;
        return res;
    }
}
