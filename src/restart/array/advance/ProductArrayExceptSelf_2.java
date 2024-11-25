package restart.array.advance;

import java.util.Arrays;

public class ProductArrayExceptSelf_2 {

    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        System.out.println(Arrays.toString(maximumProductExceptSelf(array)));
    }

    private static int [] maximumProductExceptSelf (int [] array) {
        int length = array.length;
        int [] arrayLeft = new int[array.length];
        int [] arrayRight = new int[array.length];
        int [] finalAnswer = new int[array.length];

        arrayLeft[0] = 1;
        arrayRight[array.length-1] = 1;

        for (int i=1; i < length; i++) {
            arrayLeft[i] = arrayLeft[i-1] * array[i-1];
        }

        for (int i = length-2; i >=0; i--) {
            arrayRight[i] = arrayRight[i+1] * array[i+1];
        }

        for (int i=0; i < length; i++) {
            finalAnswer[i] = arrayLeft[i] * arrayRight[i];
        }

        return finalAnswer;
    }
}
