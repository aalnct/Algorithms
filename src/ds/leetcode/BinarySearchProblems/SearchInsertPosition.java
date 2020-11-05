package ds.leetcode.BinarySearchProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/12/20.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        //int[] array = new int[] {1,3,5,6,7,9,11};
        //int[] array = new int[] {1,3,6,9,13,19,21,30,31,45,49};
        //int[] array = new int[] {1,3,5,7};
        /*int[] array = new int[]{1, 5, 6, 8, 9, 10};*/
        int[] array = new int[]{1, 5};
        int target = 2;
        // solution using linear search
        int result = searchInsertPosition(array, target);
        if (result == -1) {
            result = findMissingIndex(array, target);
        }
        System.out.println("Linear : " + result);

        // solution using binary search

        /*result = searchBinaryInsertPosition(array,target);*/
        result = searchBinaryInsertPositionWithMap(array, target);
        System.out.println("Binary Search : " + result);

    }

    private static int searchInsertPosition(int[] array, int target) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // not exists
    }

    private static int findMissingIndex(int[] array, int target) {
        int len = array.length;
        int result = 0;
        int firstElement = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < target && array[j] > target) {
                    result = ++i;
                    return result;
                }
                break;
            }
        }

        if (target < firstElement) {
            return 0;
        }

        if (result == 0) {
            return len;
        }
        return 0;
    }


    private static int searchBinaryInsertPositionWithMap(int[] array, int target) {
        int p = 0; // first element index
        int q = array.length - 1; // last element index


        while (p <= q) { // should not cross the loop itself
            int pivot = (p + q) / 2; // will provide the center/mid of array
            if (target == array[pivot]) {
                return pivot;
            }
            if (target < array[pivot]) {
                q = pivot - 1;
            } else if (target > array[pivot]) {
                p = pivot + 1;
            }
        }

        /*Map<Integer,Integer> arrayMap = new HashMap<>();
        for(int i=0;i<array.length;i++) {
            arrayMap.put(array[i], i);
            if (!arrayMap.containsKey(target)) {
                if (target < array[i]) {
                    return i;
                }else if(array[array.length-1] < target){
                    return array.length;
                }
            }
        }*/
        p=0;
        q=array.length-1;
        int mid = (p+q)/2;

        if(target < array[mid]){
            // in this way we do not have to iterate entire array
            for(int i=0;i<=mid;i++){
                if(target < array[i]){
                    return i;
                }
            }
        }else {
            if(target > array[array.length-1]){
                return array.length;
            }
            else if(target > array[mid]){
                for(int i= mid+1;i<array.length;i++){
                    if(target < array[i]){
                        return i;
                    }
                }
            }
        }

        return 0; // else just return 0, since that will be first index where this value should be
    }
}
