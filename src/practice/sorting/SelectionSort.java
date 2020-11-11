package practice.sorting;

public class SelectionSort {

    int [] array;
    int [] temp;

    public SelectionSort (int [] array) {
        this.array = array;
        this.temp = new int[array.length];
    }

    public void selectionSort() {
        for (int i=0; i < array.length-1;i++) {
            for (int j = i+1; j < array.length;j++) {
                if (array[i] > array[j]) {
                    array  = swapArray (i,j);
                }
            }
        }
    }

    private int [] swapArray(int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }

    public void print (int [] array) {
        for (int i=0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public boolean isSorted () {
        for (int i=0; i < array.length-1 ;i++) {
            if (array[i] < array [i+1]) {
                return true;
            }
        }
        return false;
    }
}
