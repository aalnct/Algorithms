import java.util.Arrays;

/**
 * Created by AmitAgarwal on 11/21/18.
 */
public class SortArray {
    //only if two array elements are out of place
    public static void main(String [] args){
        int [] array = {3,5,6,9,8,7};
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortArray(int [] array) {
        int x = -1;
        int y = -1;

        int prev = array[0]; //previous element is set to first element of an array

        for (int i = 1; i < array.length; i++) {
            if (prev > array[i]) {
                if (x == -1) {
                    x = i - 1; //x is set to previous element
                    y = i; //y is set to current element
                } else {
                    y = i; //current element
                }
            }
                prev = array[i];
        }
        swap(array, x, y);
    }
    private static void swap(int [] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
