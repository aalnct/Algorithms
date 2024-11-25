package leetcode.top_150;

import java.util.Arrays;

public class MergeSortedArrays2 {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {4,5,6};
        int n = 3;

        mergeSortedArrays(nums1,m,nums2,n);
        printArray(nums1);
    }

    private static void mergeSortedArrays(int [] nums1, int m, int [] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n -1;

        while (i >=0 && j >=0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(j >=0) {
            nums1[k--] = nums2[j--];
        }
    }

    private static void printArray(int [] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}