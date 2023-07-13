package learingcontinue;

import java.util.Arrays;

public class RemoveDuplicateArray {

    public static void main(String[] args) {
        int [] array = {1, 1, 2, 3, 3, 4, 5};
        int newLength = removeDuplicateFromArray(array);
        System.out.println(newLength);
    }

    private static int removeDuplicateFromArray(int [] array) {
        int j = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] != array[j]) {
                array[++j] = array[i];
            }
        }
        return j+1;
    }
}
