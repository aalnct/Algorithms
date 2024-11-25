package restart.array.advance;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        System.out.println(Arrays.toString(productArray(array)));
    }

    static int [] productArray (int [] array) {
        int length = array.length;
        int [] result = new int[length];

        // Step 1 Calculate prefix -- from left to right
        int prefix = 1;
        for (int i = 0; i < length; i++) {
            result[i] = prefix;
            prefix = prefix * array[i]; // 1,1,2,6
        }

        // Step 2 Calculate postfix -- from right to left
        int postfix = 1;
        for (int i = length-1; i >=0 ; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * array[i];
        }
        return result;
    }
}
