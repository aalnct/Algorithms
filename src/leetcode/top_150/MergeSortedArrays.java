package leetcode.top_150;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int [] num1 = {1, 3, 5, 7};
        int [] num2 = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergedArrays(num1,num2)));
    }

    private static int [] mergedArrays(int [] num1, int [] num2) {
        int m = num1.length;
        int n = num2.length;

        int [] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while(i < m && j < n) {
            if(num1[i] <= num2[j]) {
                merged[k++] = num1[i++];
            } else {
                merged[k++] = num2[j++];
            }
        }
        // any remaining element
        while(i < m) {
            merged[k++] = num1[i++];
        }
        while(j < n) {
            merged[k++] = num2[j++];
        }
        return merged;
    }
}
