package Sorting;

/**
 * Created by AmitAgarwal on 5/20/19.
 */
public class InsertionSort_Two {

    public static void main(String[] args){
        int [] array = new int[] {9,8,99,1,0,76,-1,50,21,500};
        insertionSort(array);
        for(Integer i : array){
            System.out.println(i);
        }
    }

    private static int [] insertionSort(int [] array){
        for(int i=1; i< array.length; i++){ // will start loop from index 1
            int element = array[i]; //will store a[i] to element so that it can be bring to sorted index later
            int j = i-1; // initialize j always less than i by 1

            while(j>=0 && array[j] > element){ // i.e. value at i-1 is less than current value in array which is being compared to sort
                array[j+1] = array[j];
                j--; // j will decrement by 1
            }

            array[j+1] = element;
        }
        return array;
    }

}
