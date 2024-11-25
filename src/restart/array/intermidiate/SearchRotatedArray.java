package restart.array.intermidiate;

/**
 * Searching in sorted rotated array
 */
public class SearchRotatedArray {

    public static void main(String[] args) {
        int [] array = {8 ,1 ,2 ,3 ,4 ,5 ,6 ,7};
        int target = 4;
        System.out.println(searchRotatedArray(array,target));
    }

    /**
     *
     * @param array
     * @param target
     * @return
     *
     * Modified version of Binary Search Tree
     */
    static int searchRotatedArray (int [] array, int target) {
        int left = 0;
        int right = array.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (array[mid] == target) {
                return mid;
            }

            // else we have to find out which part of array is sorted
            if (array[left] <= array[mid]) {
                // that means left is sorted
                // now we are trying to find where is target
                if (array[left] < target && target < array[mid]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] < target && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
