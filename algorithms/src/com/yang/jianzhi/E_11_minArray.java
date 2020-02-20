package com.yang.jianzhi;

public class E_11_minArray {
    /*
    * 题目中给出的是半有序数组，虽然传统二分告诉我们二分只能用在
    * 有序数组中，但事实上，只要是可以减治的问题，仍然可以使用二分思想。
    * */
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int mid = (i+j)/2;
            if(numbers[j]>numbers[mid] ){
                j = mid;
            }else if(numbers[j]<numbers[mid]){
                i=mid +1;
            }else{
                j--;
            }
        }
        return numbers[i];
    }
}
