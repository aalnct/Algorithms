package restart.gemini.dynamicprogramming;

import java.util.Arrays;

public class ProductArrayExceptSelf {


    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        System.out.println(Arrays.toString(productArrayExceptSelf(array)));
    }

    static int [] productArrayExceptSelf (int [] array) {
        int [] result = new int[array.length];

        int [] left = new int[array.length];
        int [] right = new int[array.length];

        left[0] = 1;

        for (int i=1; i < array.length; i++) {
            left[i] = left[i-1] * array[i-1];
        }

        right[array.length-1] = 1;

        for (int i = array.length-2; i >=0; i--) {
            right[i] = right[i+1] * array[i+1];
        }

        for (int i=0; i < array.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
