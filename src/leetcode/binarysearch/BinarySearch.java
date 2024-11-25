package leetcode.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int [] array = {-1,0,3,5,9,12};
        int search = 9;
        System.out.println(binarySearch(array,search));
    }

    private static int binarySearch (int [] array, int searchTarget) {
        int index = -1;
        int left = 0;
        int right = array.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (array[mid] == searchTarget) {
                index = mid;
                return index;
            } else if (array[mid] < searchTarget) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
