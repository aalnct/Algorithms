package restart.array.intermidiate;

import java.util.Arrays;

public class RotateArrayLeft {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        int d = 2;
        rotateArrayLeft(array,d);
        System.out.println(Arrays.toString(array));
    }

    static void rotateArrayLeft (int [] array, int d) {
        int n = array.length;
        d = d % n;

        reverse(array,0,d-1);
        reverse(array,d, n-1);
        reverse(array,0,n-1);
    }

    static void reverse (int [] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
