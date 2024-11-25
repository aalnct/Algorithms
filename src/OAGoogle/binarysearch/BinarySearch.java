package OAGoogle.binarysearch;

import java.util.PriorityQueue;

public class BinarySearch {

    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }

    static int search(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;



        while (left <= right) {
            int pivot = left + (right-left)/2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
