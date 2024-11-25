package restart.array.basic;

/***
 *
 * to find the kth Largest element using Quick Select (form of quick sort)
 */
public class QuickSelect {

    public static void main(String[] args) {
        int [] array = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargestElement(array,2));
    }

    private static int findKthLargestElement (int [] array , int k) {
        return quickSelect(array, 0, array.length-1, array.length - k);
    }

    private static int quickSelect (int [] array, int left, int right, int k) {
        // base case : if there is only 1 element in array
        if (left == right) {
            return array[left];
        }

        // partition to get the pivot index
        int pivot = partition(array,left,right);

        if (k == pivot) {
            return array[k];
        } else if (k < pivot) { // go left
            return quickSelect(array,left,pivot-1, k);
        } else  { // go right
            return quickSelect(array,pivot+1, right,k);
        }
    }

    private static int partition (int [] array, int left, int right) {
        // choose the right most element as pivot
        int pivot = array[right];
        int i = left;

        for (int j= left; j < right; j++) {
            if (array[j] <= pivot) {
                swap(array,i,j);
            }
        }

        swap(array,i,right); // move pivot to its correct place

        return i; // return pivot index
    }

    private static void swap (int [] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
