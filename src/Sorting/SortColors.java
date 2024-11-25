package Sorting;

import java.util.Arrays;

public class SortColors {


    public static void main(String[] args) {
        int [] array = {2,0,2,1,1,0};

        int min_index;

        for (int i=0; i < array.length; i++) {
            min_index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
