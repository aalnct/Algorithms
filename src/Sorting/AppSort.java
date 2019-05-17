package Sorting;

/**
 * Created by AmitAgarwal on 5/16/19.
 */
public class AppSort {
    public static void main(String [] args){
        int [] inputArray = new int[] {10,1,4,90,6,33,22,7,0,1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArray);

        for(int i = 0; i < inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }
}
