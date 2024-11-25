package restart.array.intermidiate;

public class FindMinRotatedArray {

    public static void main(String[] args) {
        int [] array = {3,4,5,0,1,2};
        System.out.println(findMinimum(array));
    }

    // we will find minimum in rotated sorted array
    static int findMinimum (int [] array) {

        int left = 0;
        int right = array.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if ( mid > 0 && array[mid] < array[mid-1] ) {
                return array[mid];
            }
            // checking which part we have to search for  (which is unsorted)
            else if (array[left] <= array[mid] && array[mid] > array[right]) {
                // that means go right
                left = mid + 1;
            } else {
                // go to left
                right = mid - 1;
            }
        }
        return array[left];
    }
}
