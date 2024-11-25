package Sorting;

import java.util.Arrays;

public class InsertionSort_3 {

    public static void main(String[] args) {
        int [] array = {1,1,4,2,1,3};
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort (int [] array) {
        for (int i=1; i< array.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && array[currentIndex-1] > array[currentIndex]) {
                int temp = array[currentIndex];
                array[currentIndex] = array[currentIndex-1];
                array[currentIndex-1] = temp;
                currentIndex -= 1;
            }
        }
        return array;
    }
}
