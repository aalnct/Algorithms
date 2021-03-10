package fb;

public class SelectionSort {

    static int[] array = {6,1,10,-1,4,99};

    public static void main(String[] args) {
        int[] sortedArray = sortedArray(array);
        for (int s : sortedArray) {
            System.out.println(s);
        }
    }

    private static int[] sortedArray (int [] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                  array =  swap(i,j);
                }
            }
        }
        return array;
    }

    private static int[] swap (int i, int j) {
        int temp;
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;

        return array;
    }
}
