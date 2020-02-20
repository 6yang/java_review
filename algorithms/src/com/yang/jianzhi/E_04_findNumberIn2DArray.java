package com.yang.jianzhi;


/*
* 思想 ：这个数组中的数
*   小的一定在左边
*   大的一定在下面
*   因此从右上角开始查找
*   和target相比缩小区间
* */
public class E_04_findNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix== null ||  matrix.length==0){
            return false;
        }
        int rows = matrix[0].length-1;
        int cols = matrix.length-1;
        int toDown = 0;
        int toLeft = rows;
        while(toDown <= cols && toLeft >=0){
            if(target == matrix[toDown][toLeft]){
                return true;
            }else if (target < matrix[toDown][toLeft]){
                toLeft-- ;
            }else if(target > matrix[toDown][toLeft]){
                toDown++;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        int [][] array = {{1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(array, 11));
    }
}
