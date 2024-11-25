package OAGoogle.array;

import java.util.Arrays;

// wingle sorting 2 is also having the same solution ...
public class WiggleSorting {

    /**
     * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]...
     * You may assume all input has valid answer.
     */

    public static void main(String[] args) {
        int [] nums = {1, 5, 1, 1,6,9};
        // wiggleSort(nums);
        wiggleSorting_2(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void wiggleSort (int [] nums) {
        Arrays.sort(nums); // this can be done using Merge sorting and quick sorting also ...

        int n = nums.length;
        // to store the array in odd and even fashion
        int [] result = new int[n]; // 1, 5, 1, 1, 6

        int mid = (n + 1)/2; //mid = 3
        int left = mid - 1; // left = 2
        int right = n -1; // right = 4

        for (int i=0; i < n; i++) {   // 1st --> i = 0
            if (i % 2 == 0) { // 1st -- > 0 % 2 == 0
                result[i] = nums[left--]; // result [0] = nums[2]
            } else {
                result[i] = nums[right--]; // 2nd --> result[1] = nums[4]
            }
        }

        // src, srcStart, destination, destinationStart, length
        System.arraycopy(result,0,nums,0, n);
    }

    static void wiggleSorting_2(int [] nums) {
      // first we will sort the array using merge sorting ...
        sort(nums);

        int n = nums.length;
        int [] result = new int[n];

        int mid = (n + 1)/2;
        int left = mid -1;
        int right = n-1;

        for (int i=0; i < n; i++) {
            if (i % 2 ==0) {
                result[i] = nums[left--];
            } else {
                result[i] = nums[right--];
            }
        }

        // copy back to orignial
        System.arraycopy(result,0,nums,0,n);
    }

    private static void sort(int [] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort (int[] inputArray, int start, int end) {
        if (end <= start) {
            return; //  done traversing array
        }
        int mid = (start + end)/2;

        // recurrsive  ...
        sort(inputArray, start, mid);
        sort(inputArray,mid + 1, end);
        mergeAfterSort(inputArray,start,mid,end);
    }

    private static void mergeAfterSort (int[] inputArray, int start, int mid, int end) {
        int [] tempArray = new int [end - start + 1];

        // index counter for left side of array
        int leftSlot = start;

        // index counter for right side of array
        int rightSlot = mid + 1;

        int k = 0; // counter for temp array to copy elements at correct index

        while (leftSlot <= mid && rightSlot <= end) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
            } else {
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
            }
            k++;
        }

        // some left values in case left is less than right ...

        if (leftSlot <= mid) {
            while(leftSlot <= mid) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
                k = k+1;
            }
        } else if (rightSlot <= end) {
            while (rightSlot <= end) {
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
                k++;
            }
        }

        for (int i=0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }
}
