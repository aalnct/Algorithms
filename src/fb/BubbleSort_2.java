package fb;

public class BubbleSort_2 {

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 4, 1, 9, -2 };
        bubbleSort(arr);
        print(arr);
    }

    private static void bubbleSort (int [] array) {
        int i, j;

        for (i = 0;i < array.length; i++) {
            // the importance of this is that it will tell bubble sort that elements are already sorted
            // so need to run the loop again O(n) time complexity
            boolean swapped = false;

            for (j=0; j< array.length-1;j++) {
                if (array[j] > array[j+1]) {
                    swapped = true;
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }

            if (!swapped) break;
        }
    }

    private static void print(int[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
