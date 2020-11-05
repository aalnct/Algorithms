package ds.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/31/20.
 */
public class SmallerThanCurrentNumber {

    public static void main(String[] args) {
        //int[] array = new int[] {8,1,2,2,3};
        /*int[] result = sortArrayDescding();
        System.out.println(Arrays.toString(result));
        int[] finalAnswer = smallerThanCurrent(result);
        System.out.println(Arrays.toString(finalAnswer));*/


        System.out.println("*********");
        int[] r = new int[] {8,1,2,2,3};
        int[] a = smallerNumbers(r);
        System.out.println(Arrays.toString(a));
    }

    public static int [] sortArrayDescding(){
        int[] array = new int[] {8,1,2,2,3};

        System.out.println("Before reverse");
        System.out.println(Arrays.toString(array));

        int length = (array.length-1);
        int middle = (array.length)/2;

        /**
         * to sort array in descding order, first sort in ascending then do a sort in place
         */
        Arrays.sort(array);
        for(int i=0; i<=middle;i++) {
            int temp = array[i];
            array[i] = array[length-i];
            array[length-i] = temp;
        }
        System.out.println("After reverse");
        return array;
    }

    public static int[] smallerThanCurrent(int [] array){
        int[] counter = new int[array.length];
        for(int i=0; i<array.length;i++){
            for(int j = i+1; j<array.length;j++){
                if(array[i] > array[j]){
                    counter[i]++;
                }
            }
        }
        return counter;
    }

    public static int[] smallerNumbers(int [] array){
        int counter [] = new int[array.length];
        for(int i=0;i<array.length;i++){
            int count = 0;
            for(int j = 0; j<array.length;j++){
                if(j!=i && array[j] < array[i]){
                    count++;
                }
            }

            counter[i] = count;
        }
        return counter;
    }


}
