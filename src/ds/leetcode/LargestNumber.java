package ds.leetcode;

/**
 * Find Largest number in an array which is atleast twice of others
 * and return its index
 */
public class LargestNumber {
    public static void main(String[] args) {
        largestIndex(new int[] {3,6,1,0});
    }

    private static int largestIndex (int [] array) {
        int maxIndex = 0;
        for (int i=0; i< array.length; ++i) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i=0; i< array.length; ++i) {
            if (maxIndex !=i && array[maxIndex] < 2*array[i]) {
                return -1;
            }
        }
        return maxIndex;
    }
}
