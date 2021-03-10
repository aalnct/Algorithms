package fb;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 6, 5, 44, 78, -4, 0, 4};
        quickSort(array, 0, array.length - 1);
        print(array);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start <= end) {
            int partitionPosition = partitionIndex(array, start, end);
            quickSort(array,start,partitionPosition-1);
            quickSort(array,partitionPosition+1,end);
        }
    }

    private static int partitionIndex (int[] array, int start, int end) {
        int pivot;
        pivot = array[end];
        int i = start-1; // from index -1

        for (int j=start;j<end;j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;
    }

    private static void print (int[] array) {
        for (int i=0;i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
