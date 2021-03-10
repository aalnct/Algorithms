package fb;

public class InsertionSort {

    public static void main(String[] args) {
        int [] array = {10,5,11,11,-20};
        array = insertionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


    static int[]  insertionSort (int [] array) {
        int length = array.length;
        // we will start from index position 1, since we consider the
        // the first position value to be sorted
        for (int i = 1; i <= length-1; i++) {
            int element;
            element = array[i];
            int j = i-1;

            while (j >= 0 && array[j] > element) {
                array[j+1] = array[j];
                j--;
            }

            array[j + 1] = element;
        }

        return array;
    }
}
