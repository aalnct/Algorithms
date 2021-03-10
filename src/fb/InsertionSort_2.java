package fb;

public class InsertionSort_2 {

    public static void main(String[] args) {
        int []  array = { 3, 8, 5, 4, 1, 9, -2 };
        insertionSort(array);
        print(array);
    }

    static void insertionSort (int [] array) {
        // we are considering first element is always sorted....
        for (int i=1; i< array.length;i++) {
            int element = array[i];
            int j = i-1; // always 1 less to compare elements
            while (j >=0 && array[j] > element) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
        }
    }

    static void print(int[] array) {
        for (int i= 0; i<= array.length-1; i++) {
            System.out.println(array[i]);
        }
    }
}
