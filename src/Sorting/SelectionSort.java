package Sorting;

/**
 * Created by Amit Agarwal on 5/13/19.
 */
public class SelectionSort {

    public static void main(String [] args){
        int [] myArray = selectionSort(new int[] {79,8,3,13,12,99,10});
        for(int i=0;i<myArray.length;i++){
            System.out.print( " " + myArray[i] + " ");
        }
    }


    private static int[] selectionSort(int [] array){
        for(int i = 0; i < array.length ; i++){
            for(int j= i+1;j<array.length ; j++){
                if(array[i] > array[j]){
                array =  swap(i,j,array);
                }
            }
        }

        return array;
    }

    private static int[] swap(int i, int j, int[] array) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

}
