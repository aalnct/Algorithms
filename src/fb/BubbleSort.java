package fb;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {64, 34, 25, 12, 22, 11, 11, 90};
        int n = arr.length;
        bubbleSort(arr,n);
        print(arr,n);
    }

    static void print (int [] arr, int n) {
        int i;
        for (i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
            // System.out.println();
        }
    }

    private static void bubbleSort (int arr[], int n) {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i< n-1; i++) {
            swapped = false;

            for (j = 0; j< (n-1); j++) { // n-1 since the last element after each iteration at the ith position will already be sorted
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
