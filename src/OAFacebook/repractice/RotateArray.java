package OAFacebook.repractice;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] array = {2,3,4,5,6};
        int k = 6;
        System.out.println("before rotation ..." +
                Arrays.toString(array));
        reverseFactor(array,k);
        System.out.println("After rotation ..." +
                Arrays.toString(array));

    }

    static void rotatedArray (int [] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    static void reverseFactor(int [] array, int k) {
        // in case where k is bigger than n (length of array)
        int n = array.length;
        k = k % n;

        rotatedArray(array, 0, n-1); // rotate entire array
        // now we will rotate only first part of array i.e. till k
        rotatedArray(array,0,k-1);
        // now rotate the last part, i.e. after k
         rotatedArray(array,k, n-1);

    }
}
