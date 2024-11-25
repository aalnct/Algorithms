package restart.array.advance;

import java.util.Arrays;

public class ArrayIntersection {

    public static void main(String[] args) {
        int [] array1 = {1,2,2,1};
        int [] array2 = {2,2};

        System.out.println(Arrays.toString(arrayIntersection(array1,array2)));
    }

    static int [] arrayIntersection (int [] array1, int [] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int [] tempArray = new int[Math.min(len1,len2)];

        int i=0 , j=0;
        int k = 0; // for auxillary array

        while (i < len1 && j < len2) {
            if (array1[i] == array2[j]) {
                // if we want to avoid duplicate
//                if (k == 0 || tempArray[k-1] != array1[i]) {
//                    tempArray[k++] = array1[i];
//                }
                tempArray[k++] = array1[i];
                i++;
                j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return tempArray;
    }
}