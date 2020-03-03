package com.yang.codeman.Array;

public class E_1001_mergeSortArray {
    //逆向双指针
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = n-1;
        int r = m+n-1;
        while(i>=0&&j>=0){
            if(A[i]>B[j]){
                A[r--] = A[i--];
            }else{
                A[r--] = B[j--];
            }
        }
        while(j>=0){
            A[r--] = B[j--];
        }
    }
}
