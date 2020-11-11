package practice.sorting;

import java.util.Random;

public class SortingMain {

    public static void main(String[] args) {
        int [] array = new int[] {4,2,6,5,44,78,-4,0,1} ;
        MergeSort mergeSort = new MergeSort(array);
        System.out.println("Merge Sort ......");
        mergeSort.mergeSort(0,array.length-1);
        mergeSort.print();
        System.out.println(mergeSort.isSorted(array));
        System.out.println("Merge Sort ends ......");

        // Selection sort
        array = new int[] {4,2,6,5,44,78,-4,0,1} ;
        SelectionSort selectionSort = new SelectionSort(array);
        System.out.println("Selection Sort ........");
        // first print before sorting
        //selectionSort.print(array);
        selectionSort.selectionSort();
        selectionSort.print(array);
        System.out.println(selectionSort.isSorted());
        System.out.println("Selection Sort ends......");

        //quick sort
        array = new int[] {4,2,6,5,44,78,-4,0,1} ;
        QuickSort quickSort = new QuickSort(array);
        System.out.println("Starting QuickSort ....");
        quickSort.quickSort(array,0,array.length-1);
        quickSort.print(array);
        System.out.println("Ending QuickSort ....");
    }
}
