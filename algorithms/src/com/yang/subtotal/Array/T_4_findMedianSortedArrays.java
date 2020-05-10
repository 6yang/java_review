package com.yang.subtotal.Array;

public class T_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1 + n2];
        if (n1 == 0) {
            if (n2 % 2 == 0) {//偶数个
                return (nums2[n2 / 2 - 1] + nums2[n2 / 2]) / 2.0;
            } else {
                return nums2[n2 / 2];
            }
        }
        if (n2 == 0) {
            if (n1 % 2 == 0) {//偶数个
                return (nums1[n1 / 2 - 1] + nums1[n1 / 2]) / 2.0;
            } else {
                return nums1[n1 / 2];
            }
        }
        int i = 0, j = 0, count = 0;
        while (count != (n1 + n2)) {
            if (i == n1) {
                while (j != n2) {
                    arr[count++] = nums2[j++];
                }
                break;
            }
            if (j == n2) {
                while (i != n1) {
                    arr[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                arr[count++] = nums1[i++];
            } else {
                arr[count++] = nums2[j++];
            }
        }

        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }
}
