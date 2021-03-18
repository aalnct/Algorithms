package fb;

import java.util.Arrays;

public class SortBinaryArray {
    public static void main(String[] args) {
        int [] array = { 1, 0, 1, 0, 1, 0, 0, 1 };
        sortBinaryArray(array);
        System.out.println(Arrays.toString(array));
    }

    static void sortBinaryArray (int [] array) {
        int zeros = 0;
        for (int value : array) {
            if (value == 0) {
                zeros++;
            }
        }
        // move all 0s to start
        int k = 0;
        while (zeros-- != 0) {
            array[k++] = 0;
        }

        while (k < array.length) {
            array[k++] = 1;
        }
    }
}
