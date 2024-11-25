package restart.array.intermidiate;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        System.out.println(" Without rotating :" + Arrays.toString(array));
        System.out.println( "Rotated Array" + Arrays.toString(rotateArray(array,2)));
    }

    static int [] rotateArray (int [] array, int k) {
        int length = array.length;
        k = k % length; // in case k is greater than length of array

        reverse(array,0,length-1);
        reverse(array,0,k-1);
        reverse(array,k,length-1);

        return array;
    }

    private static void reverse (int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
