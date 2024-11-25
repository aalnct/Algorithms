package leetcode.binarysearch;

public class SearchSortedArray {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchTarget(array, target));
    }

    static int searchTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            if (array[left] == target) {
                return left;
            }
            if (array[right] == target) {
                return right;
            } else if (array[left] < target && array[right] > target) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (array[left] < target) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return -1;
    }
}