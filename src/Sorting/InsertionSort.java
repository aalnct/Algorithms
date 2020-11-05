package Sorting;

/**
 * Created by AmitAgarwal on 5/13/19.
 */
public class InsertionSort {

    public static void main(String [] args){
        int [] array = insertionSort(new int[] {9,8,99,1,0,76,-1,50,21,500});
        for (int i = 0;i<array.length;i++){
            System.out.print(" " + array[i] + " ");
        }
    }

    private static int[] insertionSort(int [] array) {
       /* for(int i=1;i<array.length;i++){
            int element = array[i]; //assigning element the value based on position i
            int j = i-1; //j = will be position one less than i
            while(j>=0 && array[j] > element){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
        }*/
        return array;

    }

}
