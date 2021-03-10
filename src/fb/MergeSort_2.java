package fb;

import java.util.ArrayList;
import java.util.List;

public class MergeSort_2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(3);
        list = mergeSort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static List<Integer> mergeSort (List<Integer> list) {
        // convert list to array
        int [] array = new int[list.size()];
        for (int i=0;i < list.size();i++) {
            array[i] = list.get(i);
        }

        return mergeSort(array,0,array.length-1);
    }

    private static List<Integer> mergeSort(int[] array, int start, int end) {
        List<Integer> list = new ArrayList<>();
        if (start >= end) {
            return list;
        }
        int mid = (start + end) /2;
        mergeSort(array,start, mid);
        mergeSort(array,mid+1,end);
        return merge(array, start, mid, end);
    }

    private static List<Integer> merge(int[] array, int start, int mid, int end) {
        List<Integer> list = new ArrayList<>();
        int aux[] = new int[end-start+1];

        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;


        while (leftSlot <= mid && rightSlot <= end) {
            if (array[leftSlot] <= array[mid]) {
                aux[k] = array[leftSlot];
                leftSlot++;
            } else {
                aux[k] = array[rightSlot];
                rightSlot++;
            }
            k++;
        }

        // lets say what if one side of array was completed sorted, then we will miss out on second array

        if (leftSlot<=mid) {
            while (leftSlot <= mid) {
                aux[k] = array[leftSlot];
                k++;
                leftSlot++;
            }
        }

        if (rightSlot<=end) {
            while (rightSlot<=end) {
                aux[k] = array[rightSlot];
                k++;
                rightSlot++;
            }
        }

        // now copying aux into list

        for (int i = 0; i < aux.length; i++) {
            list.add(aux[i]);
        }

        return list;
    }


}
