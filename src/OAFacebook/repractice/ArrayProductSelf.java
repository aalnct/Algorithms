package OAFacebook.repractice;

import java.util.Arrays;

public class ArrayProductSelf {

    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        System.out.println(Arrays.toString(arrayProductSelf(array)));
    }

    static int [] arrayProductSelf (int [] array) {
        int n = array.length;
        int [] output = new int[n];

        int [] leftProduct = new int[n]; // store product from left panel
        int [] rightProduct = new int[n]; // store product from right panel

        leftProduct[0] = 1;
        rightProduct[n-1] = 1;
        // first get left (since we already have 1 at index 0, we will start at 1)
        for (int i=1; i < n; i++) {
            leftProduct[i] = leftProduct[i-1] * array[i-1];
        }
        // right product from n-2 since we already have 1 at n-1
        for (int i=n-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1] * array[i+1];
        }

        for (int i=0; i < n; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }

        return output;
    }
}
